import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class AlgoritmoService {
  private apiUrl1 = "http://localhost:8080/Algoritmo/todoEnm";
  private apiUrl2 = "http://localhost:8080/Algoritmo/todoEnc";
  constructor(private httpClient: HttpClient) { }
  public todoAlgoritmoEnm(): Observable<any> {
    return this.httpClient.get<any>(this.apiUrl1);
  }
  public todoAlgoritmoEnc(): Observable<any> {
    return this.httpClient.get<any>(this.apiUrl2);
  }
}
