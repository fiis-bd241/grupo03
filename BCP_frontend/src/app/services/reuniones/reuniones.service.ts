import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})

export class ReunionesService {
  private baseUrl = 'http://localhost:8080/reunion/';

  constructor(private http: HttpClient) {}

  obtenerReunionesPendientes(): Observable<any> {
    return this.http.get<any>(`${this.baseUrl}pendientes`);
  }

  obtenerReunionesCompletadas(): Observable<any> {
    return this.http.get<any>(`${this.baseUrl}completadas`);
  }

  buscarReunionesPorTexto(texto: string): Observable<any> {
    return this.http.get<any>(`${this.baseUrl}buscar`, { params: { texto } });
  }

  obtenerReunionesPorEstadoOrdenadas(estadoReunion: string, orden: string): Observable<any> {
    return this.http.get<any>(`${this.baseUrl}estado`, { params: { estadoReunion, orden } });
  }

  crearReunion(reunion: any): Observable<any> {
    return this.http.post<any>(`${this.baseUrl}crear`, reunion);
  }

  crearReunionConParticipantes(reunion: any, participanteIds: number[]): Observable<any> {
    const url = `${this.baseUrl}crear-con-participantes`;
    return this.http.post<any>(url, { ...reunion, participanteIds });
  }

  obtenerDetallesReunionPendiente(reunionId: number): Observable<any> {
    return this.http.get<any>(`${this.baseUrl}detalles-pendiente/${reunionId}`);
  }

  marcarReunionComoCompletada(reunionId: number): Observable<any> {
    return this.http.put<any>(`${this.baseUrl}marcar-completada/${reunionId}`, {});
  }

  editarReunion(reunionId: number, reunion: any): Observable<any> {
    return this.http.put<any>(`${this.baseUrl}${reunionId}`, reunion);
  }

  agregarParticipanteAReunion(reunionId: number, participanteId: number): Observable<any> {
    return this.http.post<any>(`${this.baseUrl}${reunionId}/participante/${participanteId}`, {});
  }

  eliminarParticipanteDeReunion(reunionId: number, participanteId: number): Observable<any> {
    return this.http.delete<any>(`${this.baseUrl}${reunionId}/participante/${participanteId}`);
  }
}
