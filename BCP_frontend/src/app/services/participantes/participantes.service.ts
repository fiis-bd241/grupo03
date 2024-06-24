import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ParticipantesService {
  private baseUrl = 'http://localhost:8080/participante/';


  constructor(private httpClient: HttpClient) { }

  todosParticipantesPorPedidoId(pedidoId: number): Observable<any[]> {
    return this.httpClient.get<any[]>(`${this.baseUrl}por-pedido/${pedidoId}`);
  }
  nombreCompletoPorParticipanteId(participanteId: number): Observable<string> {
    return this.httpClient.get(`${this.baseUrl}nombre/${participanteId}`, { responseType: 'text' });
  }

}
