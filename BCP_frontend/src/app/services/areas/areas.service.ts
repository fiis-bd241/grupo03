import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import {HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class AreasService {
  private apiUrl = "http://localhost:8080/area/todo";

  constructor(
    private httpClient: HttpClient,
  ) { }

  public todoAreas(): Observable<any> {
    return this.httpClient.get<any>(this.apiUrl);
  }


}
