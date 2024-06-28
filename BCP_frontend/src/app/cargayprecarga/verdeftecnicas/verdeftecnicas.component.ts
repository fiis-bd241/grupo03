import {Component, OnInit} from '@angular/core';
import {DefinicionestecnicasService} from "../../services/definicionestecnicas/definicionestecnicas.service";
import {ModeladoService} from "../../services/modelado/modelado.service";
import {ActivatedRoute} from "@angular/router";
import {NgForOf, NgIf} from "@angular/common";

@Component({
  selector: 'app-verdeftecnicas',
  standalone: true,
  imports: [
    NgForOf,
    NgIf
  ],
  templateUrl: './verdeftecnicas.component.html',
  styleUrl: './verdeftecnicas.component.css'
})
export class VerdeftecnicasComponent implements OnInit{
  deftecnicas: any[];

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
      this.modeladoService.deftecnicaPorPedido(pedidoId).subscribe(response => {
        this.deftecnicas = response;
        console.log('Definiciones técnicas obtenidas:', response);
      }, error => {
        console.error('Error al obtener definiciones técnicas:', error);
      });
    });
  }
}

