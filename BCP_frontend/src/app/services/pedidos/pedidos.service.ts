import { Injectable } from '@angular/core';
import {Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class PedidosService {
  private API_SERVER = "http://localhost:8080/pedido/";
  private apiUrl1 = "http://localhost:8080/pedido/top3";
  private apiUrl2 = "http://localhost:8080/pedido/todo";

  constructor(private httpClient: HttpClient) {}

  public getTop3Pedidos(): Observable<any> {
    return this.httpClient.get<any>(this.apiUrl1);
  }

  public todosPedidos(): Observable<any> {
    return this.httpClient.get<any>(this.apiUrl2);
  }

}
