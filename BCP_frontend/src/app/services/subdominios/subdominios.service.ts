import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";


@Injectable({
  providedIn: 'root'
})
export class SubdominiosService {

  private apiUrl = 'http://localhost:8080/subdominio/'

  constructor(private httpClient: HttpClient) { }

  public todoSudominios(dominioId): Observable<any> {
    const url = `${this.apiUrl}subdominiosxdominio/${dominioId}`;
    return this.httpClient.get<Object[]>(url);
  }
}
