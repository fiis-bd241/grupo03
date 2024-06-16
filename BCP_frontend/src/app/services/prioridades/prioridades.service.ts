import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import {HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class PrioridadesService {
  private apiUrl = "http://localhost:8080/prioridad/todo";

  constructor(
    private httpClient: HttpClient,
  ) { }

  public todoPrioridades(): Observable<any> {
    return this.httpClient.get<any>(this.apiUrl);
  }

}
