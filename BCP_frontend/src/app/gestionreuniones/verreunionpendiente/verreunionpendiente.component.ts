import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ReunionesService } from '../../services/reuniones/reuniones.service';
import { ParticipanenService } from "../../services/participanen/participanen.service";
import { ReactiveFormsModule } from "@angular/forms";
import { CommonModule } from "@angular/common";

@Component({
  selector: 'app-verreunionpendiente',
  templateUrl: './verreunionpendiente.component.html',
  standalone: true,
  imports: [
    ReactiveFormsModule, CommonModule
  ],
  styleUrls: ['./verreunionpendiente.component.css']
})
export class VerreunionpendienteComponent implements OnInit {
  reunion: any;
  participantes: any[] = [];

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private reunionesService: ReunionesService,
    private participanenService: ParticipanenService
  ) {}

  ngOnInit(): void {
    const id = +this.route.snapshot.paramMap.get('id');
    this.reunionesService.obtenerDetallesReunionPendiente(id).subscribe(data => {
      this.reunion = data[0]; // Acceder al primer (y único) elemento del arreglo
    });

    this.participanenService.obtenerParticipantesPorReunionId(id).subscribe(data => {
      this.participantes = data;
    });
  }

  marcarComoCompletada() {
    const id = +this.route.snapshot.paramMap.get('id');
    this.reunionesService.marcarReunionComoCompletada(id).subscribe(
      () => {
        console.log('Redirigiendo...');
        alert('Reunión marcada como completada, redirigiendo...');
        const id = +this.route.snapshot.paramMap.get('id');
        this.router.navigate(['/reunion-completada', id]);
      },
      error => {
        console.error('Error al marcar la reunión como completada:', error);
      }
    );
  }



  editarReunion() {
    // Redirigir a la pantalla de edición
  }

  cancelarReunion() {
    const id = +this.route.snapshot.paramMap.get('id');
    this.router.navigate(['/cancelar-reunion-pendiente', id]);
  }

  regresar() {
    this.router.navigate(['/reuniones']);
  }
}
