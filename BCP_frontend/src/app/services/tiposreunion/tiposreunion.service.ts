import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable, tap} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class TiposreunionService {
  private baseUrl = 'http://localhost:8080/tipoReunion/';

  constructor(private httpClient: HttpClient) { }

  todosTiposReunionNombres(): Observable<string[]> {
    return this.httpClient.get<string[]>(`${this.baseUrl}nombres`);
  }

  obtenerIdPorNombreTipoReunion(nombre: string): Observable<number> {
    return this.httpClient.get<number>(`${this.baseUrl}id?nombre=${nombre}`).pipe(
      tap(id => console.log('ID del tipo de reunión obtenido:', id))
    );
  }
}
