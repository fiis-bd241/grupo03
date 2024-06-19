import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { ParticipantesService } from '../../services/participantes/participantes.service';
import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
@Component({
  selector: 'app-participantes',
  templateUrl: './participantes.component.html',
  standalone: true,
  styleUrls: ['./participantes.component.css'],
  imports: [
    CommonModule
  ]
})
export class ParticipantesComponent implements OnInit {
  @Input() pedidoId: number; // ID del pedido seleccionado
  @Output() participantesSeleccionados = new EventEmitter<number[]>(); // Emite los participantes seleccionados

  participantes: any[] = []; // Array para almacenar los participantes seleccionables
  participantesSeleccionadosIds: number[] = []; // Array para almacenar los IDs de los participantes seleccionados

  constructor(private participantesService: ParticipantesService) { }

  ngOnInit(): void {
    // Llamar al servicio para obtener los participantes por pedido
    if (this.pedidoId) {
      this.participantesService.getParticipantesByPedidoId(this.pedidoId).subscribe(
        data => {
          this.participantes = data;
        },
        error => {
          console.error('Error al obtener participantes:', error);
        }
      );
    }
  }

  onParticipanteSeleccionado(event: Event, participanteId: number): void {
    if (event.target instanceof HTMLInputElement) {
      const checked = event.target.checked;
      if (checked) {
        // Agregar participanteId al array de IDs seleccionados
        this.participantesSeleccionadosIds.push(participanteId);
      } else {
        // Remover participanteId del array de IDs seleccionados
        this.participantesSeleccionadosIds = this.participantesSeleccionadosIds.filter(id => id !== participanteId);
      }
      // Emitir el array actualizado de IDs seleccionados
      this.participantesSeleccionados.emit(this.participantesSeleccionadosIds);
    }
  }
}
