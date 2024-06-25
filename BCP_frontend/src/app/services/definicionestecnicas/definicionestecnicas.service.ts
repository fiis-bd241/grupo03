import { Injectable } from '@angular/core';
import {Observable} from "rxjs";
import {HttpClient, HttpParams} from "@angular/common/http";


@Injectable({
  providedIn: 'root'
})
export class DefinicionestecnicasService {
  private apiUrl1 = "http://localhost:8080/definicionestecnicas/camposReferencia";
  private apiUrl2 = "http://localhost:8080/definicionestecnicas/tablasReferencia";
  private apiUrl3 = "http://localhost:8080/definicionestecnicas/esquemasOR";
  private apiUrl4 = "http://localhost:8080/definicionestecnicas/tablasOR";
  private apiUrl5 = "http://localhost:8080/definicionestecnicas/camposOR";
  private apiUrl6 = "http://localhost:8080/definicionestecnicas/camposEquivalentes";
  private apiUrl7 = "http://localhost:8080/definicionestecnicas/actualizar-tabla-equivalente";
  private apiUrl8 = "http://localhost:8080/definicionestecnicas/camposEquivalentesSinTabla"

  constructor(private httpClient: HttpClient) { }

  public getCamposReferencia(): Observable<any> {
    return this.httpClient.get<any>(this.apiUrl1);
  }

  public getCamposEquivalentesSinTabla() : Observable<any>{
    return this.httpClient.get<any>(this.apiUrl8);
  }

  public getTablasReferencia(): Observable<any> {
    return this.httpClient.get<any>(this.apiUrl2);
  }

  public getEsquemasOR(tabla: string): Observable<any> {
    const url = `${this.apiUrl3}/${tabla}`;
    return this.httpClient.get<any>(url);
  }

  public getTablasOR(tabla: string): Observable<any> {
    const url = `${this.apiUrl4}/${tabla}`;
    return this.httpClient.get<any>(url);
  }

  public getCamposOR(tabla: string): Observable<any> {
    const url = `${this.apiUrl5}/${tabla}`;
    return this.httpClient.get<any>(url);
  }

  public getCamposEquivalentes(): Observable<any> {
    return this.httpClient.get<any>(this.apiUrl6);
  }

  public actualizarTablaEquivalente(tabla:string, camposSeleccionados: string []): Observable<void> {
    let params = new HttpParams()
      .set('tabla',tabla)
      camposSeleccionados.forEach( campo => {
        params = params.append('camposSeleccionados', campo);
      });
    return this.httpClient.put<void>(this.apiUrl7,null,{params});
  }
}
