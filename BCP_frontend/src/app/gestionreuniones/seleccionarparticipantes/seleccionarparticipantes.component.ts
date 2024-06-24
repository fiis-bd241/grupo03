import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators, FormArray } from '@angular/forms';
import { Router } from '@angular/router';
import { ReunionesService } from '../../services/reuniones/reuniones.service';
import { ParticipantesService } from '../../services/participantes/participantes.service';
import { CommonModule } from "@angular/common";

@Component({
  selector: 'app-seleccionarparticipantes',
  templateUrl: './seleccionarparticipantes.component.html',
  standalone: true,
  imports: [
    ReactiveFormsModule, CommonModule
  ],
  styleUrls: ['./seleccionarparticipantes.component.css']
})
export class SeleccionarParticipantesComponent implements OnInit {
  formularioParticipantes: FormGroup;
  participantes: { id: number, nombreCompleto: string }[] = [];
  reunionParcial: any;

  constructor(
    private formBuilder: FormBuilder,
    private reunionesService: ReunionesService,
    private participantesService: ParticipantesService,
    private router: Router
  ) { }

  ngOnInit(): void {
    const reunionParcialString = sessionStorage.getItem('reunionParcial');
    if (reunionParcialString) {
      this.reunionParcial = JSON.parse(reunionParcialString);
      this.cargarParticipantes(this.reunionParcial.pedidoId);
    } else {
      this.router.navigate(['/paso1']);
      return;
    }

    this.formularioParticipantes = this.formBuilder.group({
      participantes: this.formBuilder.array([], Validators.required)
    });
  }

  cargarParticipantes(pedidoId: number): void {
    this.participantesService.todosParticipantesPorPedidoId(pedidoId).subscribe(ids => {
      ids.forEach(id => {
        this.participantesService.nombreCompletoPorParticipanteId(id).subscribe(nombreCompleto => {
          this.participantes.push({ id, nombreCompleto });
        });
      });
    });
  }

  onCheckboxChange(event: any) {
    const participantes: FormArray = this.formularioParticipantes.get('participantes') as FormArray;

    if (event.target.checked) {
      participantes.push(this.formBuilder.control(event.target.value));
    } else {
      const index = participantes.controls.findIndex(x => x.value === event.target.value);
      participantes.removeAt(index);
    }
  }

  onSubmit(): void {
    if (this.formularioParticipantes.valid) {
      const participantesSeleccionados = this.formularioParticipantes.value.participantes;
      this.reunionParcial.participantes = participantesSeleccionados;

      const reunion = {
        pedidoId: { pedidoId: this.reunionParcial.pedidoId },
        idEmpleado: { idEmpleado: this.reunionParcial.empleadoId },
        tipoReunionId: { tipoReunionId: this.reunionParcial.tipoReunion },
        horaInicio: this.reunionParcial.horaInicio,
        horaFin: this.reunionParcial.horaFin,
        plataforma: this.reunionParcial.plataforma,
        fecha: this.reunionParcial.fecha,
        agenda: this.reunionParcial.agenda,
        participantes: participantesSeleccionados
      };

      this.reunionesService.crearReunion(reunion).subscribe(
        reunionGuardada => {
          this.reunionesService.asociarParticipantes(reunionGuardada.id, participantesSeleccionados).subscribe(
            () => {
              sessionStorage.removeItem('reunionParcial');
              this.router.navigate(['/reuniones']);
            },
            error => {
              console.error('Error al asociar los participantes:', error);
            }
          );
        },
        error => {
          console.error('Error al crear la reunión:', error);
        }
      );
    }
  }

  cancelar(): void {
    sessionStorage.removeItem('reunionParcial');
    this.router.navigate(['/paso1']);
  }
}
