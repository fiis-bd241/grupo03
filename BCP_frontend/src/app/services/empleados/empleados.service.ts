import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class EmpleadosService {

  private baseUrl = 'http://localhost:8080/empleado/';

  constructor(private http: HttpClient) { }

  todosProductOwner(): Observable<string[]> {
    return this.http.get<string[]>(`${this.baseUrl}PO`);
  }

  public obtenerTodosLosUsuarios(): Observable<string[]> {
    return this.http.get<string[]>(this.baseUrl + 'todos');
  }
}
