import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { FormBuilder, FormGroup, ReactiveFormsModule } from '@angular/forms';
import { ReunionesService } from '../../services/reuniones/reuniones.service';
import { ParticipanenService } from '../../services/participanen/participanen.service';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-agregaracuerdos',
  templateUrl: './agregaracuerdos.component.html',
  standalone: true,
  imports: [
    ReactiveFormsModule, CommonModule
  ],
  styleUrls: ['./agregaracuerdos.component.css']
})
export class AgregaracuerdosComponent implements OnInit {
  reunion: any;
  participantes: any[] = [];
  acuerdosForm: FormGroup;

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private reunionesService: ReunionesService,
    private participanenService: ParticipanenService,
    private fb: FormBuilder
  ) {
    this.acuerdosForm = this.fb.group({
      acuerdos: ['']
    });
  }

  ngOnInit(): void {
    const id = this.route.snapshot.paramMap.get('id');
    this.reunionesService.obtenerDetallesReunionCompletada(Number(id)).subscribe(data => {
      this.reunion = data[0];
      this.acuerdosForm.patchValue({ acuerdos: this.reunion.acuerdos });
    });
    this.participanenService.obtenerParticipantesPorReunionId(Number(id)).subscribe(data => {
      this.participantes = data;
    });
  }

  confirmar(): void {
    const id = this.route.snapshot.paramMap.get('id');
    const acuerdos = this.acuerdosForm.value.acuerdos || '';
    console.log(acuerdos)

    // Enviar acuerdos como string en el cuerpo de la solicitud
    this.reunionesService.actualizarAcuerdos(Number(id), acuerdos).subscribe(() => {
      const id = this.route.snapshot.paramMap.get('id');
      this.router.navigate(['/reunion-completada', id]);;
    }, (error) => {
      console.error('Error al actualizar los acuerdos:', error);
      if (error.status === 400) {
        console.log('Detalles del error:', error.error);
      }
    });
  }

  cancelar(): void {
    const id = this.route.snapshot.paramMap.get('id');
    this.router.navigate(['/reunion-completada', id]);
  }
}
