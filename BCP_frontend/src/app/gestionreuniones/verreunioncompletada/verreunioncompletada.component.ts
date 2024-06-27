import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ReunionesService } from '../../services/reuniones/reuniones.service';
import { ParticipanenService } from "../../services/participanen/participanen.service";
import { ReactiveFormsModule } from "@angular/forms";
import { CommonModule } from "@angular/common";

@Component({
  selector: 'app-verreunioncompletada',
  templateUrl: './verreunioncompletada.component.html',
  standalone: true,
  imports: [
    ReactiveFormsModule, CommonModule
  ],
  styleUrls: ['./verreunioncompletada.component.css']
})
export class VerreunioncompletadaComponent implements OnInit {
  reunion: any;
  participantes: any[] = [];

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private reunionesService: ReunionesService,
    private participanenService: ParticipanenService
  ) {}

  ngOnInit(): void {
    const id = this.route.snapshot.paramMap.get('id');
    this.reunionesService.obtenerDetallesReunionCompletada(Number(id)).subscribe(data => {
      this.reunion = data[0];
    });
    this.participanenService.obtenerParticipantesPorReunionId(Number(id)).subscribe(data => {
      this.participantes = data;
    });
  }


  agregarAcuerdos(): void {
    const id = this.route.snapshot.paramMap.get('id');
    this.router.navigate([`/agregar-acuerdos`, id]);
  }

  generarReporte() {
    const id = this.route.snapshot.paramMap.get('id');
    this.router.navigate(['/reporte-conformidad', id]);
  }

  volver() {
    this.router.navigate(['/reuniones']);
  }
}
