import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Observable } from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class EmpleadosService {

  private baseUrl = 'http://localhost:8080/empleado/';
  private apiUrl1 ='http://localhost:8080/empleado/todoEmpleados';
  constructor(private http: HttpClient) { }

  todosProductOwner(): Observable<string[]> {
    return this.http.get<string[]>(`${this.baseUrl}PO`);
  }

  todoEmpleados(): Observable<string[]> {
    return this.http.get<any>(this.apiUrl1);
  }
  public obtenerTodosLosUsuarios(): Observable<string[]> {
    return this.http.get<string[]>(this.baseUrl + 'todos');
  }

  public agregarUsuario(empleado: any): Observable<any> {
    return this.http.post(this.baseUrl + 'agregar-empleado', empleado);
  }

  public actualizarContrasena(nombre: string): Observable<any> {
    return this.http.post(`${this.baseUrl}actualizar-contrasena`, { nombre }, {
      headers: new HttpHeaders({ 'Content-Type': 'application/json' })
    });
  }
}
