import { Injectable } from '@angular/core';
import {HttpClient, HttpParams} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class CampoService {
  private apiUrl1 = "http://localhost:8080/Campo/crearCampo";
  private apiUrl2 = "http://localhost:8080/Campo/camposPorPedido";
  constructor(private httpClient: HttpClient) { }

  public crearCampo(nivelDeAcceso: string, encriptacion: boolean, campoDDV: string, enmascarado: boolean): Observable<any> {
    const params = new HttpParams()
      .set('nivelDeAcceso', nivelDeAcceso)
      .set('encriptacion', encriptacion.toString())
      .set('campoDDV', campoDDV)
      .set('enmascarado', enmascarado.toString());
    return this.httpClient.post(this.apiUrl1, null, { params });
  }
  public camposPorPedido(pedidoId: number): Observable<any> {
    const params = new HttpParams()
      .set('pedidoId',pedidoId.toString())
    return this.httpClient.get(this.apiUrl2,{params});
  }
}
