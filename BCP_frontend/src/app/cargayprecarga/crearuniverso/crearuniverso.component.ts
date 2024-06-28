import {Component, OnInit} from '@angular/core';
import {Form, FormBuilder, FormGroup, ReactiveFormsModule, Validators} from "@angular/forms";
import {TecnologiasService} from "../../services/tecnologias/tecnologias.service";
import {PedidosService} from "../../services/pedidos/pedidos.service";
import {UniversoService} from "../../services/universo/universo.service";
import {NgForOf, NgIf} from "@angular/common";
import {RouterLink, RouterOutlet} from "@angular/router";

@Component({
  selector: 'app-crearuniverso',
  standalone: true,
  imports: [
    NgForOf,
    NgIf,
    ReactiveFormsModule,
    RouterOutlet,
    RouterLink
  ],
  templateUrl: './crearuniverso.component.html',
  styleUrl: './crearuniverso.component.css'
})
export class CrearuniversoComponent implements OnInit{
  universoForm: FormGroup;
  pedidos: any[];
  tecnologias: any[];
  constructor(
    private fb:FormBuilder,
    public tecnologiaService: TecnologiasService,
    public pedidoService: PedidosService,
    public universoService: UniversoService
  ) {
  }
  ngOnInit(): void {
    this.universoForm=this.fb.group(
      {
        pedidoId: ['', Validators.required],
        nombreTecnologia: ['', Validators.required],
        codigo: ['',Validators.required]
      }
    );
  this.pedidoService.todosPedidosId().subscribe((data =>{
    this.pedidos=data;
  }))
    this.tecnologiaService.todoTecnologias().subscribe(data =>
    {
      this.tecnologias=data
    })
  }
  guardar(): void {
    const universoData ={
      pedidoId: {pedidoId: this.universoForm.value.pedidoId},
      codigo: this.universoForm.value.codigo
    };
    this.universoService.crearUniverso(universoData).subscribe(
      respuesta =>{
        console.log('Universo Creado',respuesta);
      },
      error =>{
        console.error('Error al crear el universo',error);
      }

    )
  }
}
