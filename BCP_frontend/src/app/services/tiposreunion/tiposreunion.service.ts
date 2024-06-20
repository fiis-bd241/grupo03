import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class TiposreunionService {
  private baseUrl = 'http://tu-backend-url.com/tipoReunion/';

  constructor(private http: HttpClient) { }

  todosTiposReunionNombres(): Observable<string[]> {
    return this.http.get<string[]>(`${this.baseUrl}nombres`);
  }
}
