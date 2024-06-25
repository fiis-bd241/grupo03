import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators, FormArray } from '@angular/forms';
import { Router } from '@angular/router';
import { ReunionesService } from '../../services/reuniones/reuniones.service';
import { ParticipantesService } from '../../services/participantes/participantes.service';
import { ReportesconformidadService } from '../../services/reportesconformidad/reportesconformidad.service';
import { CommonModule } from "@angular/common";
import { switchMap, catchError } from "rxjs/operators";
import { of } from 'rxjs';

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
    private reportesConformidadService: ReportesconformidadService,
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
        agenda: this.reunionParcial.agenda
      };

      // Crear la reunión y obtener el ID máximo después de crear la reunión
      this.reunionesService.crearReunion(reunion).pipe(
        switchMap(() => this.reunionesService.getMaxReunionId()),
        switchMap((maxId: number) => {
          // Asociar participantes con el último ID creado
          return this.reunionesService.asociarParticipantes(maxId, participantesSeleccionados).pipe(
            switchMap(() => this.reportesConformidadService.existeReporteConformidad(maxId).pipe(
              switchMap((existe: boolean) => {
                console.log(this.reunionParcial.tipoReunion)
                if (existe) {
                  // Asociar reunión al reporte existente según el tipo de reunión
                  if (this.reunionParcial.tipoReunion == 1) {
                    return this.reportesConformidadService.asociarReunionAReporteEntrada(maxId);
                  } else {
                    return this.reportesConformidadService.asociarReunionAReporteSalida(maxId);
                  }
                } else {
                  // Crear nuevo reporte de conformidad y asociar según el tipo de reunión
                  return this.reportesConformidadService.crearReporteConformidad(maxId).pipe(
                    switchMap(() => {
                      if (this.reunionParcial.tipoReunion == 1) {
                        return this.reportesConformidadService.asociarReunionAReporteEntrada(maxId);
                      } else {
                        return this.reportesConformidadService.asociarReunionAReporteSalida(maxId);
                      }
                    })
                  );
                }
              })
            ))
          );
        })
      ).subscribe(
        () => {
          sessionStorage.removeItem('reunionParcial');
          this.router.navigate(['/reuniones']);
        },
        error => {
          console.error('Error al procesar la reunión:', error);
        }
      );
    }
  }

  cancelar(): void {
    sessionStorage.removeItem('reunionParcial');
    this.router.navigate(['/paso1']);
  }
}
