import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ReunionesService {
  private API_SERVER = 'http://localhost:8080'; // URL base del servidor backend

  constructor(private httpClient: HttpClient) {}

  public obtenerReunionesCompletadas(): Observable<any[]> {
    return this.httpClient.get<any[]>(`${this.API_SERVER}/reunion/completadas`);
  }

  public obtenerReunionesPendientes(): Observable<any[]> {
    return this.httpClient.get<any[]>(`${this.API_SERVER}/reunion/pendientes`);
  }

  public buscarReuniones(textoBusqueda: string): Observable<any[]> {
    return this.httpClient.get<any[]>(`${this.API_SERVER}/reunion/buscar?texto=${textoBusqueda}`);
  }

  public obtenerReunionesOrdenadas(estadoReunion: string, ordenFecha: string, ordenHora: string): Observable<any[]> {
    return this.httpClient.get<any[]>(`${this.API_SERVER}/reunion/estado/${estadoReunion}?ordenFecha=${ordenFecha}&ordenHora=${ordenHora}`);
  }

  public crearReunion(reunion: any): Observable<any> {
    return this.httpClient.post<any>(`${this.API_SERVER}/reunion`, reunion);
  }
}
