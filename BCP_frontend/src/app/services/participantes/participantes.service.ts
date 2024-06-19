import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ParticipantesService {
  private apiUrl = 'http://localhost:8080/participante'; // Ajusta la URL base según tu configuración

  constructor(private httpClient: HttpClient) {}

  getParticipantesByPedidoId(pedidoId: number): Observable<any[]> {
    return this.httpClient.get<any[]>(`${this.apiUrl}/porPedido?pedidoId=${pedidoId}`);
  }

  // Otros métodos según sea necesario para interactuar con los participantes
}
