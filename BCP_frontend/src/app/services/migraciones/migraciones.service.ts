import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class MigracionesService {
  private apiUrl = "http://localhost:8080/migracion/top3";


  constructor(private httpClient: HttpClient) { }

  public getTop3Migraciones(): Observable<any> {
    return this.httpClient.get<any>(this.apiUrl);
  }
}
