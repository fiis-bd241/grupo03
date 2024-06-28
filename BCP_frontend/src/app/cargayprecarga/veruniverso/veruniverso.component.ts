import { Component } from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {ModeladoService} from "../../services/modelado/modelado.service";
import {UniversoService} from "../../services/universo/universo.service";
import {NgForOf, NgIf} from "@angular/common";

@Component({
  selector: 'app-veruniverso',
  standalone: true,
  imports: [
    NgForOf,
    NgIf
  ],
  templateUrl: './veruniverso.component.html',
  styleUrl: './veruniverso.component.css'
})
export class VeruniversoComponent {
  universo: any[];

  constructor(
    private route: ActivatedRoute,
    private universoService: UniversoService
  ) {}

  ngOnInit(): void {
    this.buscar();
  }

  buscar(): void {
    this.route.params.subscribe(params => {
      let pedidoId = +params['pedidoId'];
      this.universoService.buscarUniversoPorPedido(pedidoId).subscribe(response => {
        console.log(pedidoId)
        this.universo = response;
        console.log('Universo obtenidas:', response);
      }, error => {
        console.error('Error al Universo', error);
      });
    });
  }

}
