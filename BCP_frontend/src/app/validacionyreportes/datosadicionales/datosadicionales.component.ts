import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, ReactiveFormsModule, Validators} from "@angular/forms";
import {MigracionesService} from "../../services/migraciones/migraciones.service";
import {PedidosService} from "../../services/pedidos/pedidos.service";
import {ProgramacionService} from "../../services/programacion/programacion.service";
import {NgForOf, NgIf} from "@angular/common";
import {RouterLink, RouterOutlet} from "@angular/router";

@Component({
  selector: 'app-datosadicionales',
  standalone: true,
  imports: [
    NgForOf,
    NgIf,
    ReactiveFormsModule,
    RouterLink,
    RouterOutlet
  ],
  templateUrl: './datosadicionales.component.html',
  styleUrl: './datosadicionales.component.css'
})
export class DatosadicionalesComponent implements OnInit {
  datosForm: FormGroup;
  migraciones: any[]
  pedidos: any[]
  constructor(
    private fb: FormBuilder,
    public migracionService: MigracionesService,
    public pedidoService: PedidosService,
    public programacionService: ProgramacionService) {}
  ngOnInit(): void {
    this.datosForm=this.fb.group(
      {
        pedidoId:  ['', Validators.required],
        migracionId: ['', Validators.required],
        frecuenciaDeEjecucion: ['', Validators.required],
        diaInicio: ['', Validators.required],
        diaFin: ['', Validators.required],
        restriccion: ['', Validators.required],
      })
    this.pedidoService.todosPedidosId().subscribe(data =>{
      this.pedidos=data;
    })
    this.datosForm.get('pedidoId').valueChanges.subscribe(pedidoId=>{
      if (pedidoId){
        this.cargarMigraciones(pedidoId);
      } else {
        this.migraciones = []
      }
    })
  }
  cargarMigraciones(pedidoId: number): void{
    this.migracionService.migracionIdporPedidoId(pedidoId).subscribe(data =>{
      this.migraciones=data;
    })
  }
  guardar(): void {
    const programacionData ={
      migracionId: {migracionId: this.datosForm.value.migracionId},
      frecuenciaDeEjecucion: {frecuenciaDeEjecucion: this.datosForm.value.frecuenciaDeEjecucion},
      diaInicio: {migraciondiaInicioId: this.datosForm.value.diaInicio},
      diaFin: {diaFin: this.datosForm.value.diaFin},
      restriccion: {restriccion: this.datosForm.value.restriccion}
    };
    this.programacionService.asignarProgramacionAMigracion(programacionData).subscribe(
      respuesta =>{
        console.log('programacion Asociada',respuesta);
      }
    )
  }
}
