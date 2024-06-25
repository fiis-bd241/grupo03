import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from "@angular/forms";
import { DefinicionestecnicasService } from "../../services/definicionestecnicas/definicionestecnicas.service";
import { AsociarTablaService } from "../../services/asociarTablas/asociar-tabla.service";
import { RouterLink, RouterOutlet } from '@angular/router';
import { CommonModule } from '@angular/common';
import { ReactiveFormsModule } from '@angular/forms';

@Component({
  selector: 'app-asociartablas',
  standalone: true,
  imports: [
    RouterOutlet,
    CommonModule,
    RouterLink,
    ReactiveFormsModule
  ],
  templateUrl: './asociartablas.component.html',
  styleUrls: ['./asociartablas.component.css']
})
export class AsociartablasComponent implements OnInit {
  asociarForm: FormGroup;
  equivalenciaForm: FormGroup;
  camposDisponibles: string[] = [];
  camposSeleccionados: string[] = [];
  camposEquivalentesSinTabla: string[] = [];
  camposEquivalentesSeleccionados: string[] = [];

  constructor(
    private fb: FormBuilder,
    private asociarTablaService: AsociarTablaService,
    private definicionesTecnicasService: DefinicionestecnicasService
  ) {}

  ngOnInit(): void {
    this.asociarForm = this.fb.group({
      tabla: ['', Validators.required],
      definicion: ['', Validators.required]
    });

    this.equivalenciaForm = this.fb.group({
      tablaEquivalente: ['', Validators.required]
    });

    this.definicionesTecnicasService.getCamposReferencia().subscribe(
      campos => {
        this.camposDisponibles = campos;
      }
    );
  }

  onCheckboxChange(event: any): void {
    const value = event.target.value;
    if (event.target.checked) {
      this.camposSeleccionados.push(value);
    } else {
      const index = this.camposSeleccionados.indexOf(value);
      if (index > -1) {
        this.camposSeleccionados.splice(index, 1);
      }
    }
  }

  onCheckboxEquivalenteChange(event: any): void {
    const value = event.target.value;
    if (event.target.checked) {
      this.camposEquivalentesSeleccionados.push(value);
    } else {
      const index = this.camposEquivalentesSeleccionados.indexOf(value);
      if (index > -1) {
        this.camposEquivalentesSeleccionados.splice(index, 1);
      }
    }
  }

  asociar(): void {
    if (this.asociarForm.valid) {
      this.asociarTablaService.asociarCamposATabla(
        this.asociarForm.value.tabla,
        this.asociarForm.value.definicion,
        this.camposSeleccionados
      ).subscribe(() => {
          console.log('Datos guardados exitosamente');
          this.cargarCamposEquivalentesSinTabla();
        },
        error => {
          console.error('Error al guardar los datos', error);
        }
      );
    } else {
      console.error('Formulario inválido');
    }
  }

  cargarCamposEquivalentesSinTabla(): void {
    this.definicionesTecnicasService.getCamposEquivalentesSinTabla().subscribe(
      campos => {
        this.camposEquivalentesSinTabla = campos;
      },
      error => {
        console.error('Error al cargar los campos equivalentes sin tabla', error);
      }
    );
  }

  agregarEquivalencia(): void {
    if (this.equivalenciaForm.valid) {
      this.definicionesTecnicasService.actualizarTablaEquivalente(
        this.equivalenciaForm.value.tablaEquivalente,
        this.camposEquivalentesSeleccionados
      ).subscribe(() => {
          console.log('Tabla equivalente agregada exitosamente');
        },
        error => {
          console.error('Error al agregar la tabla equivalente', error);
        }
      );
    } else {
      console.error('Formulario de equivalencia inválido');
    }
  }
}


