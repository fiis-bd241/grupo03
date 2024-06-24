import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ReportesconformidadService {
  private baseUrl = 'http://localhost:8080/reporte-conformidad/';

  constructor(private http: HttpClient) {}

  generarVistaPreviaReporte(reunionId: number): Observable<any> {
    return this.http.get(`${this.baseUrl}vista-previa-reporte/${reunionId}`);
  }

  actualizarEstadoReporteConformidad(reunionId: number): Observable<any> {
    return this.http.put(`${this.baseUrl}actualizar-estado/${reunionId}`, {});
  }
}
