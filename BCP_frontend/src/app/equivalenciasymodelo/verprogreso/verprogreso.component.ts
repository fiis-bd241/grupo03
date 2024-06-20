import { Component, OnInit } from '@angular/core';
import { FormBuilder, ReactiveFormsModule } from '@angular/forms';
import { TareasService } from "../../services/tareas/tareas.service";
import { EstadosService } from "../../services/estados/estados.service";
import { CommonModule } from '@angular/common';
import { FormsModule } from "@angular/forms";
import {RouterLink} from "@angular/router";

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [
    ReactiveFormsModule,
    CommonModule,
    FormsModule,
    RouterLink
  ],
  templateUrl: './verprogreso.component.html',
  styleUrl: './verprogreso.component.css'
})
export class VerprogresoComponent implements OnInit {
  progreso: any[] = [];
  estados: any[] = [];
  estadosSeleccionado: any;

  constructor(
    private fb: FormBuilder,
    public tareasService: TareasService,
    public estadosService: EstadosService
  ) {}

  ngOnInit(): void {
    this.estadosService.todoEstados().subscribe((data) => {
      this.estados = data;

      this.cargarTareas();
    });
  }

  cargarTareas(): void {
    const migracionId = 1;
    this.tareasService.todoTareas(migracionId).subscribe(data => {
      this.progreso = data;
    });
  }

  actualizarEstadoTarea(tareaId: number, nuevoEstadoId: number): void {
    this.tareasService.actualizarEstadoTareas(tareaId, nuevoEstadoId).subscribe(
      () => {
        // Después de actualizar el estado de la tarea, cargar las tareas nuevamente
        this.cargarTareas();
      }
    );
  }
}
