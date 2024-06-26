import { Component, OnInit } from '@angular/core';
import { ReportesconformidadService} from "../../services/reportesconformidad/reportesconformidad.service"; // Ajusta la ruta según la ubicación de tu servicio
import { Observable } from 'rxjs';
import{CommonModule} from "@angular/common";
import {RouterLink} from "@angular/router";

@Component({
  selector: 'app-listareportesconformidad',
  templateUrl: './listareportesconformidad.component.html',
  imports: [CommonModule, RouterLink],
  standalone: true,
  styleUrls: ['./listareportesconformidad.component.css']
})
export class ListareportesconformidadComponent implements OnInit {
  ultimosPedidos: number[] = [];
  reportesPorPedidos: any[] = [];

  constructor(private reportesconformidadService: ReportesconformidadService) { }

  ngOnInit(): void {
    this.obtenerCuatroUltimosPedidos();
  }

  obtenerCuatroUltimosPedidos(): void {
    this.reportesconformidadService.obtenerCuatroUltimosPedidos().subscribe(
      pedidos => {
        console.log('Últimos pedidos:', pedidos);
        this.ultimosPedidos = pedidos;
        this.ultimosPedidos.forEach(pedidoId => {
          this.obtenerReportesPorPedido(pedidoId);
        });
      },
      error => {
        console.error('Error al obtener los últimos pedidos', error);
      }
    );
  }

  obtenerReportesPorPedido(pedidoId: number): void {
    this.reportesconformidadService.obtenerReportesPorPedidoId(pedidoId).subscribe(
      reportes => {

        this.reportesPorPedidos.push({ pedidoId, reportes });
      },
      error => {
      }
    );
  }

}
