import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class MigracionesService {
  private apiUrl1 = "http://localhost:8080/migracion/top3";
  private apiUrl2 = "http://localhost:8080/migracion/crear-migracion";

  constructor(private httpClient: HttpClient) { }

  public getTop3Migraciones(): Observable<any> {
    return this.httpClient.get<any>(this.apiUrl1);
  }

  public crearMigracion(migracion: any): Observable<any> {
    return this.httpClient.post(this.apiUrl2, migracion);
  }
}
