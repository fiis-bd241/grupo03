import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ReportesconformidadService {
  private baseUrl = 'http://localhost:8080/reporte-conformidad/';
  private base2Url = 'http://localhost:8080/reunion-reporte-conformidad/'

  constructor(private httpClient: HttpClient) {}

  generarVistaPreviaReporte(reunionId: number): Observable<any> {
    return this.httpClient.get(`${this.baseUrl}vista-previa-reporte/${reunionId}`);
  }

  vistaReporteConformidadGenerado(reporteId: number): Observable<any> {
    return this.httpClient.get(`${this.baseUrl}vista-reporte-generado/${reporteId}`);
  }

  actualizarEstadoReporteConformidad(reunionId: number): Observable<any> {
    return this.httpClient.put(`${this.baseUrl}actualizar-estado/${reunionId}`, {});
  }
  asociarReunionAReporteEntrada(reunionId: number): Observable<any> {
    return this.httpClient.post(`${this.base2Url}asociar-entrada?reunionId=${reunionId}`, {});
  }

  asociarReunionAReporteSalida(reunionId: number): Observable<any> {
    return this.httpClient.post(`${this.base2Url}asociar-salida?reunionId=${reunionId}`, {});
  }

  existeReporteConformidad(reunionId: number): Observable<boolean> {
    return this.httpClient.get<boolean>(`${this.baseUrl}existe?reunionId=${reunionId}`);
  }
  crearReporteConformidad(reunionId: number): Observable<any> {
    return this.httpClient.post(`${this.baseUrl}crear?reunionId=${reunionId}`, {});
  }
  obtenerCuatroUltimosPedidos(): Observable<number[]> {
    return this.httpClient.get<number[]>(`${this.baseUrl}ultimos-pedidos`);
  }
  obtenerReportesPorPedidoId(pedidoId: number): Observable<any[]> {
    return this.httpClient.get<any[]>(`${this.baseUrl}por-pedido/${pedidoId}`);
  }
}
