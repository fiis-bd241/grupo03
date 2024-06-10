import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class EstadosService {
  private apiUrl = "http://localhost:8080/estado/todo";


  constructor(
    private httpClient: HttpClient,
  ) { }

  public todoEstados(): Observable<any> {
    return this.httpClient.get<any>(this.apiUrl);
  }
}
