import { Injectable } from '@angular/core';
import {Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class ProgramacionService {
  private apiUrl = "http://localhost:8080/Programacion/asignar";
  constructor(private httpClient:HttpClient) { }
  public asignarProgramacionAMigracion(programacion: any): Observable<any> {

    return this.httpClient.post(this.apiUrl,programacion);
  }
}
