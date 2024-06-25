import { Injectable } from '@angular/core';
import {HttpClient, HttpParams} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class InsertDataService {
  private apiUrl1 = 'http://localhost:8080/insercion-cn/guardar';

  constructor(private httpClient: HttpClient) { }

  public insertData(esquemaId1: number, campo1: string, esquemaId2: number, campo2: string, subdominioId: number, definicionCampo: string): Observable<void> {
    const params = new HttpParams()
      .set('esquemaId1', esquemaId1.toString())
      .set('campo1', campo1)
      .set('esquemaId2', esquemaId2.toString())
      .set('campo2', campo2)
      .set('subdominioId', subdominioId.toString())
      .set('definicionCampo', definicionCampo);
    return this.httpClient.post<void>(this.apiUrl1, null, { params });
  }
}
