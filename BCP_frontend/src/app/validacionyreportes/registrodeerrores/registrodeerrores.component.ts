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
      nombre: ['', Validators.required],
      nombreError: ['', Validators.required],
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
    this.tipoerrorService.todoErrores().subscribe(data =>{
      this.errores=data;
    })
    this.empleadoService.todoEmpleados().subscribe(data =>{
      this.empleados=data;
    })
  };
  guardar(): void {
    const {pedidoId, migracionId, nombre, nombreError, causaError, correccionError}=this.erroresForm.value

    console.log('Bachicha',migracionId, nombre, nombreError, causaError, correccionError)

    this.registroerroresService.registrarError(migracionId, nombre, nombreError, causaError, correccionError).subscribe(
      respuesta =>{
        console.log('Error asociado',respuesta);
      },
      error => {
        console.error('Error registrar el error', error);
      }
    )
  }
  cargarMigraciones(pedidoId: number): void{
    this.migracionService.migracionIdporPedidoId(pedidoId).subscribe(data =>{
      this.migraciones=data;
    })
  }



}
