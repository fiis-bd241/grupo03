import { Component } from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {ReunionesService} from "../../services/reuniones/reuniones.service";
import {ReportesconformidadService} from "../../services/reportesconformidad/reportesconformidad.service";
import {NgForOf, NgIf} from "@angular/common";

@Component({
  selector: 'app-verreporteconformidadgenerado',
  standalone: true,
  imports: [
    NgForOf,
    NgIf
  ],
  templateUrl: './verreporteconformidadgenerado.component.html',
  styleUrl: './verreporteconformidadgenerado.component.css'
})
export class VerreporteconformidadgeneradoComponent {
  pedidoId: number;
  reuniones: any[] = [];
  acuerdos: string[] = [];

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private reunionesService: ReunionesService,
    private reportesconformidadService: ReportesconformidadService
  ) {}

  ngOnInit(): void {
    const reunionId = Number(this.route.snapshot.paramMap.get('id'));
    this.cargarDatos(reunionId);
  }

  cargarDatos(reunionId: number): void {
    this.reportesconformidadService.vistaReporteConformidadGenerado(reunionId).subscribe(data => {
      if (data.length > 0) {
        this.reuniones = data.map(row => ({
          id: row[0],
          tipo: row[1],
          fecha: row[2],
          horaInicio: row[3],
          horaFin: row[4],
          acuerdos: row[5]
        }));
        this.pedidoId = data[0][6]; // Asumiendo que el pedidoId está en la séptima columna
        this.acuerdos = this.reuniones.map(r => r.acuerdos).flat();
      }
    });
  }
  volver() {
    this.router.navigate(['/lista-reportes-conformidad']);
  }

}
