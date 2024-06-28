import { Injectable } from '@angular/core';
import {HttpClient, HttpParams} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class RegistroerroresService {
  private apiUrl1 = "http://localhost:8080/RegistroDeErrores/causasycorrecciones";
  private apiUrl2 = "http://localhost:8080/RegistroDeErrores/registrar";
  constructor(private httpClient: HttpClient) { }
  public todoCausasYCorreciones(pedidoId: number): Observable<any> {
    return this.httpClient.get<any>(`${this.apiUrl1 }/${pedidoId}`);
  }
  public registrarError(migracionId: number,nombre: string,nombreError:string,correcionError:string,causaError:string): Observable<any> {
    const params = new HttpParams()
      .set('migracionId', migracionId.toString())
      .set('nombre', nombre.toString())
      .set('nombreError', nombreError.toString())
      .set('correcionError', correcionError.toString())
  .set('causaError', causaError.toString());
    console.log('Profis', correcionError,causaError)
    return this.httpClient.post(this.apiUrl2, null, { params });
  }
}
