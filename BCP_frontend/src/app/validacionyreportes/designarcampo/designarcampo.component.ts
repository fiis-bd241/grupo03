import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, ReactiveFormsModule, Validators} from "@angular/forms";
import {PedidosService} from "../../services/pedidos/pedidos.service";
import {CampoService} from "../../services/campo/campo.service";
import {TipodatoService} from "../../services/tipodato/tipodato.service";
import {ActivatedRoute, RouterLink, RouterOutlet} from "@angular/router";
import {NgForOf, NgIf} from "@angular/common";

@Component({
  selector: 'app-designarcampo',
  standalone: true,
  imports: [
    ReactiveFormsModule,
    RouterOutlet,
    NgForOf,
    NgIf,
    RouterLink
  ],
  templateUrl: './designarcampo.component.html',
  styleUrl: './designarcampo.component.css'
})
export class DesignarcampoComponent implements OnInit{
  designarForm: FormGroup;
  campos: any []
  naccesos: any []
  encriptados: any []
  enmascarados: any []
  pedidos: any []
  constructor(
    private  fb: FormBuilder,
    public pedidoService: PedidosService,
    public campoService: CampoService,
    public tipodatoService:TipodatoService
  ){}
  ngOnInit(): void {
    this.designarForm= this.fb.group(
      {
        pedidoId: ['',Validators.required],
        campoDDV: ['',Validators.required],
        nivelDeAcceso: ['',Validators.required],
        enmascarado: ['',Validators.required],
        encriptado: ['',Validators.required]
      });
    this.pedidoService.todosPedidosId().subscribe(data=>{
      this.pedidos=data;})
    this.designarForm.get('pedidoId').valueChanges.subscribe(pedidoId=>{
      if (pedidoId){
        this.cargarCampos(pedidoId);
      } else {
        this.campos = []
      }
    })
    this.tipodatoService.todoEncriptado().subscribe(data=>{
      this.encriptados=data;})
    this.tipodatoService.todoEnmascarado().subscribe(data=>{
      this.enmascarados=data;})
    this.tipodatoService.TodoNivelesDeAcceso().subscribe(data=>{
      this.naccesos=data;})
  }

  cargarCampos(pedidoId: number): void{
    this.campoService.camposPorPedido(pedidoId).subscribe(data =>{
      this.campos=data;
    })
  }

  guardar(): void {

    const { pedidoId, campoDDV, nivelDeAcceso, enmascarado, encriptado } = this.designarForm.value;
    this.campoService.crearCampo(nivelDeAcceso,encriptado,campoDDV,enmascarado).subscribe(
      respuesta =>{
        console.log('Campo Asignado',respuesta);
      }
    )
  }

}
