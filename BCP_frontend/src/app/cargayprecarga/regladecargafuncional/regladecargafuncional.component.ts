import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, FormsModule, ReactiveFormsModule, Validators} from "@angular/forms";
import {TecnologiasService} from "../../services/tecnologias/tecnologias.service";
import {PedidosService} from "../../services/pedidos/pedidos.service";
import {MigracionesService} from "../../services/migraciones/migraciones.service";
import {UniversoService} from "../../services/universo/universo.service";
import {RegladecargafuncionalService} from "../../services/regladecargafuncional/regladecargafuncional.service";
import {NgForOf, NgIf} from "@angular/common";
import {RouterOutlet} from "@angular/router";

@Component({
  selector: 'app-regladecargafuncional',
  standalone: true,
  imports: [
    FormsModule,
    NgForOf,
    NgIf,
    ReactiveFormsModule,
    RouterOutlet
  ],
  templateUrl: './regladecargafuncional.component.html',
  styleUrl: './regladecargafuncional.component.css'
})
export class RegladecargafuncionalComponent implements OnInit{
  rcfForm: FormGroup;
  pedidos: any[];
  migraciones: any[];
  tecnologias: any[];
  constructor(
    private fb : FormBuilder,
    public tecnologiaService: TecnologiasService,
    public pedidoService: PedidosService,
    public migracionService: MigracionesService,
    public regladecargafuncionalService: RegladecargafuncionalService
  ) {
  }
  ngOnInit(): void {
    this.rcfForm=this.fb.group(
      {
        pedidoId: ['', Validators.required],
        nombreTecnologia: ['', Validators.required],
        migracionId: [',', Validators.required],
        logica: ['',Validators.required]

      })
    this.pedidoService.todosPedidosId().subscribe(data =>{
      this.pedidos=data;
    })
    this.tecnologiaService.todoTecnologias().subscribe(data =>{
      this.tecnologias=data;
    })
    this.rcfForm.get('pedidoId').valueChanges.subscribe(pedidoId=>{
      if (pedidoId){
        this.cargarMigraciones(pedidoId);
      } else {
        this.migraciones = []
      }
    });
  }

  cargarMigraciones(pedidoId: number): void{
    this.migracionService.migracionIdporPedidoId(pedidoId).subscribe(data =>{
      this.migraciones=data;
    })
  }
  guardar(): void {
    const rcfData ={
      migracionId: {migracionId: this.rcfForm.value.migracionId},
      tecnologiaId: {tecnologiaId: this.rcfForm.value.nombreTecnologia},
      logica: this.rcfForm.value.logica
    };
    this.regladecargafuncionalService.crearRegladeCargaFuncional(rcfData).subscribe(
      respuesta =>{
        console.log('Regla Funcional Creada',respuesta);
      },
      error =>{
        console.error('Error al crear regla funcional',error);
        console.log('Regla Funcional Error',rcfData)
      }

    )
  }
}
