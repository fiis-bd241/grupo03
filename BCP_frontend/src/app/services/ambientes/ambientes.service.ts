import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class AmbientesService {
  private apiUrl = "http://localhost:8080/ambiente/todo";


  constructor(
    private httpClient: HttpClient,
  ) { }

  public todoAmbientes(): Observable<any> {
    return this.httpClient.get<any>(this.apiUrl);
  }
}
