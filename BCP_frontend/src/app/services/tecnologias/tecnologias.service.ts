import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class TecnologiasService {
  private apiUrl = "http://localhost:8080/tecnologia/todo";


  constructor(
    private httpClient: HttpClient,
  ) { }

  public todoTecnologias(): Observable<any> {
    return this.httpClient.get<any>(this.apiUrl);
  }
}

