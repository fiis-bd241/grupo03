import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class TipodatoService {
  private apiUrl1 = "http://localhost:8080/TipoDato/todoEncriptado";
  private apiUrl2 = "http://localhost:8080/TipoDato/todoEnmascarado";
  private apiUrl3 = "http://localhost:8080/TipoDato/todoNivelesDeAcceso";
  constructor(private httpClient:HttpClient) { }
  public todoEncriptado(): Observable<any> {
    return this.httpClient.get<any>(this.apiUrl1);
  }
  public todoEnmascarado(): Observable<any> {
    return this.httpClient.get<any>(this.apiUrl2);
  }
  public TodoNivelesDeAcceso(): Observable<any> {
    return this.httpClient.get<any>(this.apiUrl3);
  }
}
