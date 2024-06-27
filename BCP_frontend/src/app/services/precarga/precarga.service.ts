import { Injectable } from '@angular/core';
import {HttpClient, HttpParams} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class PrecargaService {
  private apiUrl1 = "http://localhost:8080/PreCarga/Obligatorias";
  private apiUrl2 = "http://localhost:8080/PreCarga/Opcionales";
  private apiUrl3 = "http://localhost:8080/PreCarga/relacionarCPC";
  private apiUrl4 = "http://localhost:8080/PreCarga/cargaObligatoria";
  constructor(private httpClient: HttpClient) { }
  public relacionarCargaPrecarga(migracionId: number, nombreRegla: string): Observable<any> {
    const params = new HttpParams()
      .set('migracionId', migracionId.toString())
      .set('nombreRegla', nombreRegla.toString())
    return this.httpClient.post(this.apiUrl3, null, { params });
  }
  public reglasObligatorias(): Observable<any>{
    return this.httpClient.get(this.apiUrl1);
  }
  public reglasOpcionales(): Observable<any>{
    return this.httpClient.get(this.apiUrl2);
  }
  public reglaDeCargaObligatoria(PreCarga: any): Observable<any>{
    return this.httpClient.post(this.apiUrl4,PreCarga);
  }
}
