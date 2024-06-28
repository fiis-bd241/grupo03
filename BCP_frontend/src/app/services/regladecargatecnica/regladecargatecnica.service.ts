import { Injectable } from '@angular/core';
import {HttpClient, HttpParams} from "@angular/common/http";
import {Observable} from "rxjs";
import {considerSettingUpAutocompletion} from "@angular/cli/src/utilities/completion";

@Injectable({
  providedIn: 'root'
})
export class RegladecargatecnicaService {
  private apiUrl1 = "http://localhost:8080/RCT/enviarRCT";
  private apiUrl2 = "http://localhost:8080/RCT/finalizarRCT";
  private apiUrl3 = "http://localhost:8080/RCT/corregirRCT";
  private apiUrl4 = "http://localhost:8080/RCT/actualizarRCT";
  private apiUrl5 = "http://localhost:8080/RCT/buscarRCT";

  constructor(private httpClient: HttpClient) { }
  public reglaTecnicaPorMigracion(pedidoId: number): Observable<any> {
    const url = `${this.apiUrl5}/${pedidoId}`;
    console.log('URLLLL',url)
    return this.httpClient.get<any>(url);
  }
  public enviarReglaParaRevision(migracionId: number, codigo: string): Observable<any> {
    const params = new HttpParams()
      .set('migracionId', migracionId.toString())
      .set('codigo', codigo.toString())
    return this.httpClient.post(this.apiUrl1, null, { params });
  }
  public actualizarReglaParaRevision(migracionId: number, codigo: string): Observable<any> {
    const params = new HttpParams()
      .set('migracionId', migracionId.toString())
      .set('codigo', codigo.toString())
    return this.httpClient.put(this.apiUrl4, null, { params });
  }
  public finalizarReglaDeCarga(migracionId: number, comentario: string): Observable<any> {
    const params = new HttpParams()
      .set('migracionId', migracionId.toString())
      .set('comentario', comentario.toString())
    console.log('params',params)
    return this.httpClient.put(this.apiUrl2, null, { params });
  }
  public corregirReglaDeCarga(migracionId: number, comentario: string): Observable<any> {
    const params = new HttpParams()
      .set('migracionId', migracionId.toString())
      .set('comentario', comentario.toString())
    console.log('params',params)
    return this.httpClient.put(this.apiUrl3, null, { params });
  }

}

