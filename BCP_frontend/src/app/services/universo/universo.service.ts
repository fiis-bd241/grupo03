import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class UniversoService {
  private apiUrl1 = "http://localhost:8080/Universo/buscarPorPedido"
  private apiUrl2= "http://localhost:8080/Universo/crearUniverso"
  constructor(private httpClient: HttpClient) { }

  public buscarUniversoPorPedido(pedidoId: number): Observable<any> {
    const url = `${this.apiUrl1}/${pedidoId}`;
    console.log('HASTA ACA',url)
    return this.httpClient.get<any>(url);
  }
  public crearUniverso(Universo: any): Observable<any>{
    console.log('Universo', Universo);
    return this.httpClient.post(this.apiUrl2,Universo);
  }
}
