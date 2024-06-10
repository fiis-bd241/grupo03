import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class SquadsService {
  private apiUrl = "http://localhost:8080/squad/todo";

  constructor(
    private httpClient: HttpClient,
  ) { }

  public todoSquads(): Observable<any> {
    return this.httpClient.get<any>(this.apiUrl);
  }
}
