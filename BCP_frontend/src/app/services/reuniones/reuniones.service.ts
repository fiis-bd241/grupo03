import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})

export class ReunionesService {
  private baseUrl = 'http://localhost:8080/reunion/';

  constructor(private httpClient: HttpClient) {}

  obtenerReunionesPendientes(): Observable<any> {
    return this.httpClient.get<any>(`${this.baseUrl}pendientes`);
  }

  obtenerReunionesCompletadas(): Observable<any> {
    return this.httpClient.get<any>(`${this.baseUrl}completadas`);
  }

  buscarReunionesPorTexto(texto: string): Observable<any> {
    return this.httpClient.get<any>(`${this.baseUrl}buscar`, { params: { texto } });
  }

  obtenerReunionesPorEstadoOrdenadas(estadoReunion: string, orden: string): Observable<any> {
    return this.httpClient.get<any>(`${this.baseUrl}estado`, { params: { estadoReunion, orden } });
  }

  crearReunion(reunion: any): Observable<any> {
    return this.httpClient.post(`${this.baseUrl}crear`, reunion);
  }

  asociarParticipantes(reunionId: number, participantes: number[]): Observable<any> {
    return this.httpClient.post<any>(`${this.baseUrl}${reunionId}/participantes`, participantes);
  }



  obtenerDetallesReunionPendiente(reunionId: number): Observable<any> {
    return this.httpClient.get<any>(`${this.baseUrl}detalles-pendiente/${reunionId}`);
  }
  obtenerDetallesReunionCompletada(reunionId: number): Observable<any> {
    return this.httpClient.get<any>(`${this.baseUrl}detalles-completada/${reunionId}`);
  }

  marcarReunionComoCompletada(reunionId: number): Observable<any> {
    return this.httpClient.put<any>(`${this.baseUrl}marcar-completada/${reunionId}`, {});
  }

  editarReunion(reunionId: number, reunion: any): Observable<any> {
    return this.httpClient.put<any>(`${this.baseUrl}${reunionId}`, reunion);
  }

  agregarParticipanteAReunion(reunionId: number, participanteId: number): Observable<any> {
    return this.httpClient.post<any>(`${this.baseUrl}${reunionId}participante/${participanteId}`, {});
  }

  eliminarParticipanteDeReunion(reunionId: number, participanteId: number): Observable<any> {
    return this.httpClient.delete<any>(`${this.baseUrl}${reunionId}participante/${participanteId}`);
  }
  getMaxReunionId(): Observable<number> {
    return this.httpClient.get<number>(`${this.baseUrl}maxid`);
  }
  cancelarReunion(reunionId: number): Observable<any> {
    return this.httpClient.delete(`${this.baseUrl}cancelar/${reunionId}`);
  }
  actualizarAcuerdos(id: number, acuerdos: string): Observable<void> {
    return this.httpClient.put<void>(`${this.baseUrl}${id}/acuerdos`,
      acuerdos);
  }
  buscarReunionesPendientesPorPedido(pedidoId: number): Observable<any[]> {
    return this.httpClient.get<any[]>(`${this.baseUrl}pendiente-pedido/${pedidoId}`);
  }
  buscarReunionesCompletadasPorPedido(pedidoId: number): Observable<any[]> {
    return this.httpClient.get<any[]>(`${this.baseUrl}completada-pedido/${pedidoId}`);
  }
}
