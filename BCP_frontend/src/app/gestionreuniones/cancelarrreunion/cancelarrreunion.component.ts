import { Component } from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {ReunionesService} from "../../services/reuniones/reuniones.service";
import {ParticipanenService} from "../../services/participanen/participanen.service";
import {NgForOf} from "@angular/common";

@Component({
  selector: 'app-cancelarrreunion',
  standalone: true,
  imports: [
    NgForOf
  ],
  templateUrl: './cancelarrreunion.component.html',
  styleUrl: './cancelarrreunion.component.css'
})
export class CancelarrreunionComponent {
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

regresar(){
    const id = this.route.snapshot.paramMap.get('id');
    this.router.navigate(['/reunion-pendiente', id]);
}
  eliminarreunion() {
    const id = this.route.snapshot.paramMap.get('id');

    this.reunionesService.cancelarReunion(Number(id)).subscribe(
      () => {
        alert('Reunión cancelada exitosamente.');
        this.router.navigate(['/reuniones']);
      },
      error => {
        console.error('Error al cancelar la reunión:', error);
        // Manejar el error adecuadamente según tus necesidades
      }
    );
  }

}
