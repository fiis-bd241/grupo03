import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, FormsModule, ReactiveFormsModule, Validators} from "@angular/forms";
import {PedidosService} from "../../services/pedidos/pedidos.service";
import {MigracionesService} from "../../services/migraciones/migraciones.service";
import {RegladecargatecnicaService} from "../../services/regladecargatecnica/regladecargatecnica.service";
import {NgForOf, NgIf} from "@angular/common";
import {RouterOutlet} from "@angular/router";

@Component({
  selector: 'app-retroalimentacion',
  standalone: true,
  imports: [
    FormsModule,
    NgForOf,
    NgIf,
    ReactiveFormsModule,
    RouterOutlet
  ],
  templateUrl: './retroalimentacion.component.html',
  styleUrl: './retroalimentacion.component.css'
})
export class RetroalimentacionComponent implements OnInit{
feedbackForm: FormGroup;
pedidos :  any[];
migraciones : any[];
constructor(
  private fb : FormBuilder,
  public pedidoService: PedidosService,
  public migracionService: MigracionesService,
  public regladecargatecnicaService:RegladecargatecnicaService
) {
}
  ngOnInit(): void {
  this.feedbackForm=this.fb.group(
    {
      pedidoId: ['', Validators.required],
      migracionId: [',', Validators.required],
      comentario: ['',Validators.required]
    }
  )
    this.pedidoService.todosPedidosId().subscribe(data =>{
      this.pedidos=data;
    })
    this.feedbackForm.get('pedidoId').valueChanges.subscribe(pedidoId=>{
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
    const {pedidoId, migracionId, comentario}=this.feedbackForm.value
    ;
    this.regladecargatecnicaService.finalizarReglaDeCarga(migracionId,comentario).subscribe(
      respuesta =>{
        console.log('Regla Tecnica Finalizada',respuesta);
      },
      error =>{
        console.error('Error al enviar regla tecanica',error);
        console.log ('Regla Tecnica Error',this.feedbackForm.value)
      }

    )
  }
}
