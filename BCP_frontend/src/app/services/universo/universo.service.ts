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
  public buscarUniversoPorPedido(Pedido: any): Observable<any>{
    return this.httpClient.get(this.apiUrl1,Pedido);
  }
  public crearUniverso(Universo: any): Observable<any>{
    console.log('Universo', Universo);
    return this.httpClient.post(this.apiUrl2,Universo);
  }
}
