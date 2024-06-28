import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ModeladoService {
  private apiUrl1 = "http://localhost:8080/modelado/Modelo";
  private apiUrl2 = "http://localhost:8080/modelado/crear-modelo";
  private apiUrl3 = "http://localhost:8080/modelado/actualizar-esquema-tabla";
  private apiUrl4 = "http://localhost:8080/modelado/modporped";
  private apiUrl5 = "http://localhost:8080/modelado/deftporped";

  constructor(private httpClient: HttpClient) { }

  public getModelo(campo: string): Observable<any> {
    const url = `${this.apiUrl1}/${campo}`;
    return this.httpClient.get<any>(url);
  }
  public modeladoPorPedido(pedidoId: number): Observable<any> {
    const url = `${this.apiUrl4}/${pedidoId}`;
    return this.httpClient.get<any>(url);
  }
  public deftecnicaPorPedido(pedidoId: number): Observable<any> {
    const url = `${this.apiUrl5}/${pedidoId}`;
    return this.httpClient.get<any>(url);
  }
  public crearModelo(campo: string, campoDDV: string, campoLlave: boolean, campoDescarta: boolean): Observable<any> {
    const params = new HttpParams()
      .set('campo', campo)
      .set('campoDDV', campoDDV)
      .set('campoLlave', campoLlave.toString())
      .set('campoDescarta', campoDescarta.toString());
    return this.httpClient.post(this.apiUrl2, null, { params });
  }

  public actualizarEsquemaTabla(campo: string, esquemaDDV: string, tablaDDV: string): Observable<any> {
    const params = new HttpParams()
      .set('esquemaDDV', esquemaDDV)
      .set('tablaDDV', tablaDDV);
    const url = `${this.apiUrl3}/${campo}`;
    return this.httpClient.put(url, null, { params });
  }
}


