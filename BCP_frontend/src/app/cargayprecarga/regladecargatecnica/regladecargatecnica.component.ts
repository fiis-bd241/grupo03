import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, ReactiveFormsModule, Validators} from "@angular/forms";
import {TecnologiasService} from "../../services/tecnologias/tecnologias.service";
import {PedidosService} from "../../services/pedidos/pedidos.service";
import {MigracionesService} from "../../services/migraciones/migraciones.service";
import {RegladecargafuncionalService} from "../../services/regladecargafuncional/regladecargafuncional.service";
import {RegladecargatecnicaService} from "../../services/regladecargatecnica/regladecargatecnica.service";
import {NgForOf, NgIf} from "@angular/common";
import {RouterLink, RouterOutlet} from "@angular/router";

@Component({
  selector: 'app-regladecargatecnica',
  standalone: true,
  imports: [
    NgForOf,
    NgIf,
    ReactiveFormsModule,
    RouterOutlet,
    RouterLink
  ],
  templateUrl: './regladecargatecnica.component.html',
  styleUrl: './regladecargatecnica.component.css'
})
export class RegladecargatecnicaComponent implements OnInit{
  rctForm: FormGroup;
  pedidos: any[];
  migraciones: any[];
  tecnologias: any[];
  constructor(
    private fb : FormBuilder,
    public tecnologiaService: TecnologiasService,
    public pedidoService: PedidosService,
    public migracionService: MigracionesService,
    public regladecargatecnicaService: RegladecargatecnicaService
  ) {
  }
  ngOnInit(): void {
    this.rctForm=this.fb.group(
      {
        pedidoId: ['', Validators.required],
        nombreTecnologia: ['', Validators.required],
        migracionId: ['', Validators.required],
        codigo: ['',Validators.required]

      })
    this.pedidoService.todosPedidosId().subscribe(data =>{
      this.pedidos=data;
    })
    this.tecnologiaService.todoTecnologias().subscribe(data =>{
      this.tecnologias=data;
    })
    this.rctForm.get('pedidoId').valueChanges.subscribe(pedidoId=>{
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
    const {pedidoId, nombreTecnologia, migracionId, codigo}=this.rctForm.value
    ;
    this.regladecargatecnicaService.enviarReglaParaRevision(migracionId,codigo).subscribe(
      respuesta =>{
        console.log('Regla Tecnica Enviada',respuesta);
      },
      error =>{
        console.error('Error al enviar regla tecanica',error);
        console.log ('Regla Tecnica Error',this.rctForm.value)
      }

    )
  }
}

