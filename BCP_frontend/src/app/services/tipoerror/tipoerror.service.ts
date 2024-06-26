import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class TipoerrorService {
  private apiUrl1 = "http://localhost:8080/TipoError/todoNombresErrores";

  constructor(private httpClient: HttpClient) { }
  public todoNombresErrores(): Observable<any> {
    return this.httpClient.get<any>(this.apiUrl1);
  }
}
