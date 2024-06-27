import {Component, OnInit} from '@angular/core';
import {Form, FormBuilder, FormGroup, ReactiveFormsModule, Validators} from "@angular/forms";
import {PedidosService} from "../../services/pedidos/pedidos.service";
import {MigracionesService} from "../../services/migraciones/migraciones.service";
import {PrecargaService} from "../../services/precarga/precarga.service";
import {NgForOf, NgIf} from "@angular/common";
import {RouterLink, RouterOutlet} from "@angular/router";

@Component({
  selector: 'app-precarga',
  standalone: true,
  imports: [
    NgForOf,
    NgIf,
    RouterLink,
    RouterOutlet,
    ReactiveFormsModule
  ],
  templateUrl: './precarga.component.html',
  styleUrl: './precarga.component.css'
})
export class PrecargaComponent implements OnInit{
  filtrarporpedidoForm: FormGroup;
  pedidos: any[];
  migraciones: any[];
  reglasopcionales: any[];
  reglasobligatorias: any[];
  constructor(
    private fb : FormBuilder,
    public pedidoService: PedidosService,
    public migracionService: MigracionesService,
    public precargaService: PrecargaService
  ) {
  }
  ngOnInit(): void {
    this.filtrarporpedidoForm=this.fb.group(
      {
        pedidoId: ['',Validators.required],
        migracionId: ['',Validators.required]
      }
    )
    this.pedidoService.todosPedidosId().subscribe(data => {
      this.pedidos=data;
    })
    this.filtrarporpedidoForm.get('pedidoId').valueChanges.subscribe(pedidoId=>{
      if (pedidoId){
        this.cargarMigraciones(pedidoId);
      } else {
        this.migraciones = []
      }
    });
    this.precargaService.reglasObligatorias().subscribe(data =>{
      this.reglasobligatorias=data;
    })
    this.precargaService.reglasOpcionales().subscribe(data=>{
      this.reglasopcionales=data;
    })
  }
  cargarMigraciones(pedidoId: number): void{
    this.migracionService.migracionIdporPedidoId(pedidoId).subscribe(data =>{
      this.migraciones=data;
    })
  }
  recomendar(migracionId,nombreRegla): void {
    let migracion: any=migracionId;
    let nombreReg: any=nombreRegla;
    console.log(migracionId,nombreRegla);
    this.precargaService.relacionarCargaPrecarga(+migracionId,nombreRegla).subscribe(
      respuesta =>{
        console.log('Pre Carga Recomendada',respuesta);
      },
      error =>{
        console.error('Error al recomendar',error);
      }

    )
  }
}

