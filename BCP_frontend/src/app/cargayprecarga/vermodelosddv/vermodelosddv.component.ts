import { Component } from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {ModeladoService} from "../../services/modelado/modelado.service";
import {NgForOf, NgIf} from "@angular/common";

@Component({
  selector: 'app-vermodelosddv',
  standalone: true,
  imports: [
    NgForOf,
    NgIf
  ],
  templateUrl: './vermodelosddv.component.html',
  styleUrl: './vermodelosddv.component.css'
})
export class VermodelosddvComponent {
  modelosDDV: any[];

  constructor(
    private route: ActivatedRoute,
    private modeladoService: ModeladoService
  ) {}

  ngOnInit(): void {
    this.buscar();
  }

  buscar(): void {
    this.route.params.subscribe(params => {
      let pedidoId = +params['pedidoId'];
      this.modeladoService.modeladoPorPedido(pedidoId).subscribe(response => {
        this.modelosDDV = response;
        console.log('Modelos obtenidas:', response);
      }, error => {
        console.error('Error al obtener los modelos', error);
      });
    });
  }

}
