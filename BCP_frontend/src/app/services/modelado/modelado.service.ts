import { Injectable } from '@angular/core';
import {Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class ModeladoService {
  private apiUrl1 = "http://localhost:8080/modelado/Modelo";
  private apiUrl2 = "http://localhost:8080/modelado/crear-modelo";
  private apiUrl3 = "http://localhost:8080/modelado/actualizar-esquema-tabla";




  constructor(private httpClient: HttpClient) { }

  public getModelo(campo: string): Observable<any> {
    const url = `${this.apiUrl1}/${campo}`;
    return this.httpClient.get<any>(url);
  }

  public crearModelo(campoDDV: string, campoLlave: boolean, campoDescarta: boolean, campo: string): Observable<any> {
    const body = { campoDDV, campoLlave, campoDescarta, campo };
    return this.httpClient.post<any>(this.apiUrl2, body);
  }

  public actualizarEsquemaTabla(esquemaDDV: string, tablaDDV: string, campo: string): Observable<any> {
    const body = { esquemaDDV, tablaDDV, campo };
    return this.httpClient.put<any>(this.apiUrl3, body);
  }
}
