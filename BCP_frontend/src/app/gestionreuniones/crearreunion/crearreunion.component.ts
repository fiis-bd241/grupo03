import { Component, OnInit } from '@angular/core';
import { PedidosService } from '../../services/pedidos/pedidos.service';
import { ReunionesService } from '../../services/reuniones/reuniones.service';
import { ParticipantesService } from '../../services/participantes/participantes.service';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms'
import {ParticipantesComponent} from "../participantes/participantes.component";

@Component({
  selector: 'app-crearreunion',
  templateUrl: './crearreunion.component.html',
  standalone: true,
  styleUrls: ['./crearreunion.component.css'],
  imports: [CommonModule, FormsModule, ParticipantesComponent]
})
export class CrearReunionComponent implements OnInit {
  pedidos: any[] = []; // Array para almacenar los pedidos disponibles
  pedidoId: number; // ID del pedido seleccionado
  fecha: string; // Fecha de la reunión
  horaInicio: string; // Hora de inicio de la reunión
  horaFin: string; // Hora de fin de la reunión
  plataforma: string; // Plataforma de la reunión
  participantesSeleccionados: number[] = []; // Array para almacenar los IDs de los participantes seleccionados
  agenda: string; // Agenda de la reunión

  constructor(
    private pedidosService: PedidosService,
    private reunionesService: ReunionesService,
    private participantesService: ParticipantesService
  ) { }

  ngOnInit(): void {
    // Llamar al servicio para obtener los pedidos disponibles
    this.pedidosService.todosPedidosId().subscribe(
      data => {
        this.pedidos = data;
      },
      error => {
        console.error('Error al obtener los pedidos:', error);
      }
    );
  }

  onParticipantesSeleccionados(participantesIds: number[]): void {
    // Manejar los IDs de los participantes seleccionados
    this.participantesSeleccionados = participantesIds;
  }

  guardarReunion(): void {
    // Crear objeto de reunión a guardar
    const nuevaReunion = {
      pedidoId: this.pedidoId,
      fecha: this.fecha,
      horaInicio: this.horaInicio,
      horaFin: this.horaFin,
      plataforma: this.plataforma,
      participantes: this.participantesSeleccionados,
      agenda: this.agenda,
      estado: 'pendiente' // Estado por defecto
    };

    // Llamar al servicio para guardar la reunión
    this.reunionesService.crearReunion(nuevaReunion).subscribe(
      response => {
        console.log('Reunión creada correctamente:', response);
        // Aquí puedes redirigir o hacer otras acciones después de guardar la reunión
      },
      error => {
        console.error('Error al crear la reunión:', error);
      }
    );
  }
}
