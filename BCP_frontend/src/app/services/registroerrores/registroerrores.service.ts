import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class RegistroerroresService {
  private apiUrl1 = "http://localhost:8080/RegistroDeErrores/causasycorrecciones";
  private apiUrl2 = "http://localhost:8080/RegistroDeErrores/registrar";
  constructor(private httpClient: HttpClient) { }
  public todoCausasYCorreciones(pedidoId: number): Observable<any> {
    return this.httpClient.get<any>(`${this.apiUrl1 }/${pedidoId}`);
  }
  public registrarError(RegistroDeErrores: any): Observable<any> {

    return this.httpClient.post(this.apiUrl2, RegistroDeErrores);
  }
}
