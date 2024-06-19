import { Injectable } from '@angular/core';
import {Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class PedidosService {
  private apiUrl1 = "http://localhost:8080/pedido/top3";
  private apiUrl2 = "http://localhost:8080/pedido/todo";
  private apiUrl3 = "http://localhost:8080/pedido/todo-id";
  private apiUrl4 = "http://localhost:8080/pedido/crear-pedido";

  constructor(private httpClient: HttpClient) {}

  public getTop3Pedidos(): Observable<any> {
    return this.httpClient.get<any>(this.apiUrl1);
  }

  public todosPedidos(): Observable<any> {
    return this.httpClient.get<any>(this.apiUrl2);
  }

  public todosPedidosId(): Observable<any> {
    return this.httpClient.get<any>(this.apiUrl3);
  }

  public crearPedido(pedido: any): Observable<any> {

    return this.httpClient.post(this.apiUrl4, pedido);
  }
}
