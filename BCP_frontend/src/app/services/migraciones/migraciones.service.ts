import { Injectable } from '@angular/core';
import {HttpClient, HttpParams} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class MigracionesService {
  private apiUrl1 = "http://localhost:8080/migracion/top3";
  private apiUrl2 = "http://localhost:8080/migracion/crear-migracion";
  private apiUrl3 = "http://localhost:8080/migracion/todo";
  private apiUrl4 = "http://localhost:8080/migracion/mIdpId";

  constructor(private httpClient: HttpClient) { }

  public getTop3Migraciones(): Observable<any> {
    return this.httpClient.get<any>(this.apiUrl1);
  }

  public crearMigracion(migracion: any): Observable<any> {
    return this.httpClient.post(this.apiUrl2, migracion);
  }

  public buscarMigracionesPorPedidoId(pedidoId: number): Observable<any> {
    return this.httpClient.get<any>(`${this.apiUrl3}/${pedidoId}`);
  }
  public migracionIdporPedidoId(pedidoId: number): Observable<any> {
    const params = new HttpParams()
      .set('pedidoId',pedidoId.toString())
    return this.httpClient.get(this.apiUrl4,{params});
  }
}
