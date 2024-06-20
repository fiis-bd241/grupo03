import { Component,OnInit} from '@angular/core';
import { FormBuilder, ReactiveFormsModule } from '@angular/forms';
import {TareasService} from "../../services/tareas/tareas.service";
import {RouterLink, RouterOutlet} from '@angular/router';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-verreportetareas',
  standalone: true,
  imports: [
    RouterOutlet,
    ReactiveFormsModule,
    CommonModule,
    RouterLink
  ],
  templateUrl: './verreportetareas.component.html',
  styleUrl: './verreportetareas.component.css'
})
export class VerReporteTareasComponent implements OnInit{
  reportes: any[] = [];
  evaluaciones: any[] = [];

  constructor(
    public tareasService: TareasService
  ) {}

  ngOnInit(): void {
    const migracionId =1;
    this.tareasService.evaluacionTareas(migracionId).subscribe(data => {
      this.evaluaciones = data;
    });

    this.tareasService.reporteTareas(migracionId).subscribe(data => {
      this.reportes = data;
    });
  }

}
