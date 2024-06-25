import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from "@angular/common/http";
import { Observable } from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class AsociarTablaService {
  private apiUrl = 'http://localhost:8080/asociar-tablas/asociar';

  constructor(private httpClient: HttpClient) {}

  public asociarCamposATabla(tabla: string, definicion: string, camposSeleccionados: string[]): Observable<void> {
    let params = new HttpParams()
      .set('tabla', tabla)
      .set('definicion', definicion);

    camposSeleccionados.forEach(campo => {
      params = params.append('camposSeleccionados', campo);
    });

    return this.httpClient.put<void>(this.apiUrl, null, { params });
  }
}
