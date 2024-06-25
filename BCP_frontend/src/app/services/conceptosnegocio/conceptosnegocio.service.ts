import { Injectable } from '@angular/core';
import {Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class ConceptosnegocioService {
  private apiUrl1 = "http://localhost:8080/conceptosNegocio/todo";
  private apiUrl2 = "http://localhost:8080/conceptosNegocio/top7";
  private apiUrl3 = "http://localhost:8080/conceptosNegocio/actualizar-definicion-tabla";

  constructor(private httpClient: HttpClient) {}

  public todoConceptos() : Observable<any>{
    return this.httpClient.get<any>(this.apiUrl1);
  }

  public getTop7Conceptos(): Observable<any> {
      return this.httpClient.get<any>(this.apiUrl2);
    }


}
