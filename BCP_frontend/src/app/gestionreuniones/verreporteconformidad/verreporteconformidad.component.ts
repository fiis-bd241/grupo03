import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ReunionesService } from '../../services/reuniones/reuniones.service';
import { ReportesconformidadService } from "../../services/reportesconformidad/reportesconformidad.service";
import { ReactiveFormsModule } from "@angular/forms";
import { CommonModule } from "@angular/common";

@Component({
  selector: 'app-verreporteconformidad',
  templateUrl: './verreporteconformidad.component.html',
  standalone: true,
  imports: [
    ReactiveFormsModule, CommonModule
  ],
  styleUrls: ['./verreporteconformidad.component.css']
})
export class VerreporteconformidadComponent implements OnInit {
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
    this.reportesconformidadService.generarVistaPreviaReporte(reunionId).subscribe(data => {
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

  cancelar() {
    this.router.navigate(['/reunion-completada', this.route.snapshot.paramMap.get('id')]);
  }

  confirmar() {
    const reunionId = Number(this.route.snapshot.paramMap.get('id'));
    this.reportesconformidadService.actualizarEstadoReporteConformidad(reunionId).subscribe(() => {
      this.router.navigate(['/reuniones']);
    });
  }
}
