import { Injectable } from '@angular/core';
import {Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class TareasService {
  private apiUrl1 = "http://localhost:8080/tarea/todo/{migracionId}";
  private apiUrl2 = "http://localhost:8080/tarea/reporte/{migracionId}";
  private apiUrl3 = "http://localhost:8080/tarea/evaluacion/{migracionId}";
  private apiUrl4 = "http://localhost:8080/tarea/actualizar-estado-tarea";

  constructor(private httpClient: HttpClient) { }

  public todoTareas(migracionId: number): Observable<any> {
    const url = `${this.apiUrl1.replace('{migracionId}', migracionId.toString())}`;
    return this.httpClient.get<any>(url);
  }

  public reporteTareas(migracionId: number): Observable<any> {
    const url = `${this.apiUrl2.replace('{migracionId}', migracionId.toString())}`;
    return this.httpClient.get<any>(url);
  }

  public evaluacionTareas(migracionId): Observable<any> {
    const url = `${this.apiUrl3.replace('{migracionId}', migracionId.toString())}`;
    return this.httpClient.get<any>(url);
  }

  public actualizarEstadoTareas(tareaId: number, nuevoEstado:any): Observable<any> {
    return this.httpClient.post<any>(`${this.apiUrl4}/${tareaId}`, { estado: nuevoEstado });
  }
}
