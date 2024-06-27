import { Component, OnInit } from '@angular/core';
import { ReportesconformidadService } from "../../services/reportesconformidad/reportesconformidad.service";
import { FormBuilder, FormGroup, ReactiveFormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { RouterLink } from '@angular/router';
import {PedidosService} from "../../services/pedidos/pedidos.service";
@Component({
  selector: 'app-buscarreporte',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule, RouterLink],
  templateUrl: './buscarreporte.component.html',
  styleUrl: './buscarreporte.component.css'
})
export class BuscarreporteComponent {
  pedidos: number[] = [];
  reportesPorPedido: any[] = [];
  searchForm: FormGroup;

  constructor(
    private reportesconformidadService: ReportesconformidadService,
    private pedidosServices: PedidosService,
    private fb: FormBuilder
  ) {
    this.searchForm = this.fb.group({
      pedidoId: ['']
    });
  }

  ngOnInit(): void {
    this.pedidosServices.todosPedidosId().subscribe(data => {
      this.pedidos = data;
    });
  }

  obtenerReportesPorPedido(): void {
    const pedidoId = this.searchForm.value.pedidoId;
    if (pedidoId) {
      this.reportesconformidadService.obtenerReportesPorPedidoId(pedidoId).subscribe(
        reportes => {
          this.reportesPorPedido = reportes;
        },
        error => {
          console.error(`Error al obtener los reportes para el pedido ${pedidoId}`, error);
        }
      );
    }
  }
}
