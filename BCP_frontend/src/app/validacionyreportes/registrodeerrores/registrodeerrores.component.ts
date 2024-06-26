import {Component, OnInit} from '@angular/core';
import {Form, FormBuilder, FormGroup, FormsModule, ReactiveFormsModule, Validators} from "@angular/forms";
import {MigracionesService} from "../../services/migraciones/migraciones.service";
import {PedidosService} from "../../services/pedidos/pedidos.service";
import {TipoerrorService} from "../../services/tipoerror/tipoerror.service";
import {error} from "@angular/compiler-cli/src/transformers/util";
import {RegistroerroresService} from "../../services/registroerrores/registroerrores.service";
import {NgForOf, NgIf} from "@angular/common";
import {RouterOutlet} from "@angular/router";
import {EmpleadosService} from "../../services/empleados/empleados.service";

@Component({
  selector: 'app-registrodeerrores',
  standalone: true,
  imports: [
    FormsModule,
    NgForOf,
    NgIf,
    ReactiveFormsModule,
    RouterOutlet
  ],
  templateUrl: './registrodeerrores.component.html',
  styleUrl: './registrodeerrores.component.css'
})

export class RegistrodeerroresComponent implements OnInit{
  erroresForm: FormGroup;
  errores: any[];
  pedidos: any[];
  migraciones: any[];
  empleados: any[];
  constructor(
    private fb:FormBuilder,
    public migracionService: MigracionesService,
    public pedidoService: PedidosService,
    public tipoerrorService: TipoerrorService,
    public registroerroresService: RegistroerroresService,
    public empleadoService: EmpleadosService
  ) {
  }

  ngOnInit(): void {
    this.erroresForm = this.fb.group({
      pedidoId: ['', Validators.required],
      migracionId: ['', Validators.required],
      nombreError: ['', Validators.required],
      nombre: ['', Validators.required],
      causaError: ['', Validators.required],
      correccionError: ['', Validators.required]}
    )
  this.pedidoService.todosPedidosId().subscribe(data =>{
    this.pedidos=data;
    });
    this.erroresForm.get('pedidoId').valueChanges.subscribe(pedidoId=>{
      if (pedidoId){
        this.cargarMigraciones(pedidoId);
      } else {
        this.migraciones = []
      }
    })
    this.tipoerrorService.todoNombresErrores().subscribe(data =>{
      this.errores=data;
    })
    this.empleadoService.todoNombres().subscribe(data =>{
      this.empleados=data;
    })
  };
  guardar(): void {
    const registrodeerrorData ={
      migracionId: {migracionId: this.erroresForm.value.migracionId},
      nombre: {nombre: this.erroresForm.value.nombre},
      nombreError: {nombreError: this.erroresForm.value.nombreError},
      correccionError: this.erroresForm.value.correccionError,
      causaError: this.erroresForm.value.causaError,
    };
    this.registroerroresService.registrarError(registrodeerrorData).subscribe(
      respuesta =>{
        console.log('programacion Asociada',respuesta);
      },
      error => {
        console.error('Error al crear el pedido', error);
        console.log(registrodeerrorData);
      }
    )
  }
  cargarMigraciones(pedidoId: number): void{
    this.migracionService.migracionIdporPedidoId(pedidoId).subscribe(data =>{
      this.migraciones=data;
    })
  }



}
