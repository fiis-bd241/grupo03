import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class DominiosService {
  private apiUrl = 'http://localhost:8080/dominio/todo'

  constructor(private httpClient: HttpClient) {}

  public todoDominios(): Observable<any> {
    return this.httpClient.get<any>(this.apiUrl);
  }
}
