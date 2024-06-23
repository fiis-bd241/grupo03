import { Component, OnInit } from '@angular/core';
import { FormBuilder, ReactiveFormsModule } from '@angular/forms';
import { TareasService } from "../../services/tareas/tareas.service";
import { EstadosService } from "../../services/estados/estados.service";
import { CommonModule } from '@angular/common';
import { FormsModule } from "@angular/forms";
import {RouterLink} from "@angular/router";
import {Router} from "@angular/router";

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

  constructor(
    private fb: FormBuilder,
    public tareasService: TareasService,
    public estadosService: EstadosService,
    private router: Router
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

  redirigirSegunSeccion(seccion: string): void {
    switch (seccion){
      case 'Agregar Concepto de Negocio':
        this.router.navigate(['/ver-conceptosNegocio']);
        break;
      case 'Agregar Equivalencia':
        this.router.navigate(['/buscar-equivalencias']);
        break;
      case 'Insertar Modelo DDV':
        this.router.navigate(['/buscar-modelo']);
        break;
      default:
      break;
    }
  }
}
