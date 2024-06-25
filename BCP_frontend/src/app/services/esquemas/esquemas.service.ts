import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class EsquemasService {

  private apiUrl = 'http://localhost:8080/esquema/'
  constructor(private httpClient: HttpClient) { }

  public todoEsquemas(ambienteId: number): Observable<Object[]> {
    const url = `${this.apiUrl}esquemasxambiente/${ambienteId}`;
    return this.httpClient.get<Object[]>(url);
  }
}
