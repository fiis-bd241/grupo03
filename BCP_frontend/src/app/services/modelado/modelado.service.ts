import { Injectable } from '@angular/core';
import {Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class ModeladoService {
  private apiUrl1 = "http://localhost:8080/modelado/Modelo";
  private apiUrl2 = "http://localhost:8080/modelado/crea-modelo";
  private apiUrl3 = "http://localhost:8080/modelado/actualizar-esquema-tabla";




  constructor(private httpClient: HttpClient) { }

  public getModelo(campo: string): Observable<any> {
    const url = `${this.apiUrl1}/${campo}`;
    return this.httpClient.get<any>(url);
  }

  public crearModelo(): Observable<any> {
    return this.httpClient.get<any>(this.apiUrl2)
  }

  public actualizarEsquemaTabla(): Observable<any>{
    return this.httpClient.get<any>(this.apiUrl3)
  }
}
