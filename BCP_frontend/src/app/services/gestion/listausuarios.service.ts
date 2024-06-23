import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ListaUsuariosService {
  private apiUrl = 'http://localhost:8080/empleado/todos';

  constructor(private httpClient: HttpClient) { }

  public obtenerTodosLosUsuarios(): Observable<any> {
    return this.httpClient.get<any>(this.apiUrl);
  }
}
