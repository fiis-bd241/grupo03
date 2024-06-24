import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ParticipanenService {
  private apiUrl = 'http://localhost:8080/participaEn';

  constructor(private http: HttpClient) {}

  obtenerParticipantesPorReunionId(reunionId: number): Observable<any> {
    return this.http.get(`${this.apiUrl}/${reunionId}`);
  }
}
