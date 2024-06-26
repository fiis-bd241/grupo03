import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, ReactiveFormsModule, Validators} from "@angular/forms";
import {RegistroerroresService} from "../../services/registroerrores/registroerrores.service";
import {PedidosService} from "../../services/pedidos/pedidos.service";
import {ActivatedRoute, RouterLink} from "@angular/router";
import {NgForOf, NgIf} from "@angular/common";

@Component({
  selector: 'app-vererrores',
  standalone: true,
  imports: [
    NgForOf,
    NgIf,
    ReactiveFormsModule,
    RouterLink
  ],
  templateUrl: './vererrores.component.html',
  styleUrl: './vererrores.component.css'
})
export class VererroresComponent implements  OnInit{
  erroresForm: FormGroup;
  errores : any[]=[];
  pedidos : any[]=[];
  pedidoId: number;
  constructor(
    private fb : FormBuilder,
    private route: ActivatedRoute,
    public registroerroresService: RegistroerroresService,
    public pedidosService: PedidosService
) {}

  ngOnInit(): void {
    this.erroresForm = this.fb.group(
      {
        pedidoId: ['', Validators.required]
      }
    );
    this.route.params.subscribe(params =>{
      this.pedidoId = +params['pedidoId'];
      this.erroresForm.patchValue({
        pedidoId: this.pedidoId
      })
      this.buscar();
    })
    this.pedidosService.todosPedidosId().subscribe(data =>
    {
      this.pedidos=data;
    })


  }
  buscar(): void {
    const pedidoId = this.erroresForm.value.pedidoId;
    this.registroerroresService.todoCausasYCorreciones(pedidoId).subscribe(response => {
      this.errores = response;
      console.log('Errores obtenidos', response);
    });
  }
}
