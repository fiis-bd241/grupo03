import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class RegladecargafuncionalService {
  private apiUrl1 = "http://localhost:8080/RCF/RCFPorMigracion"
  private apiUrl2 = "http://localhost:8080/RCF/crearRCF"
  constructor(private httpClient: HttpClient) { }

  public buscarReglaFuncPorMigracion(migracionId: number): Observable<any> {
    const url = `${this.apiUrl1}/${migracionId}`;
    console.log('H',url)
    return this.httpClient.get<any>(url);
  }
  public crearRegladeCargaFuncional(ReglaDeCargaFuncional: any): Observable<any>{
    return this.httpClient.post(this.apiUrl2,ReglaDeCargaFuncional);
  }

}
