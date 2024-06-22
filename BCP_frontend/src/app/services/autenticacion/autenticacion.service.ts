import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AutenticacionService {

  private loginUrl = 'http://localhost:8080/api/auth/login';

  constructor(private http: HttpClient) { }

  login(dni: string, contrasena: string): Observable<any> {
    const params = { dni, contrasena };
    return this.http.post(this.loginUrl, null, { params });
  }
}
