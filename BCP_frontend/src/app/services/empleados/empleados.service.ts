import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable, tap} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class EmpleadosService {

  private baseUrl = 'http://localhost:8080/empleado/';

  constructor(private httpClient: HttpClient) { }

  todosProductOwner(): Observable<string[]> {
    return this.httpClient.get<string[]>(`${this.baseUrl}PO`);
  }

  obtenerIdPorNombreEmpleado(nombreCompleto: string): Observable<number> {
    return this.httpClient.get<number>(`${this.baseUrl}id?nombreCompleto=${nombreCompleto}`).pipe(
      tap(id => console.log('ID del empleado obtenido:', id))
    );
  }

}
