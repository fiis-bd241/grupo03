import { Component, OnInit } from '@angular/core';
import { FormBuilder, ReactiveFormsModule } from '@angular/forms';
import {DefinicionestecnicasService} from "../../services/definicionestecnicas/definicionestecnicas.service";
import {RouterLink, RouterOutlet} from '@angular/router';
import { CommonModule } from '@angular/common';
import {FormsModule} from "@angular/forms";

@Component({
  selector: 'app-verequivalencias',
  standalone: true,
  imports: [
    RouterOutlet,
    ReactiveFormsModule,
    CommonModule,
    RouterLink,
    FormsModule
  ],
  templateUrl: './verequivalencias.component.html',
  styleUrl: './verequivalencias.component.css'
})
export class VerequivalenciasComponent implements OnInit{
  tablas: string[] = [];
  tablaSeleccionada: string = '';
  esquemasOR: any;
  tablasOR: any;
  camposOR: any;

  constructor(
    public definicionestecnicasService: DefinicionestecnicasService
  ) { }

  ngOnInit(): void {
    this.cargarTablas();
  }

  cargarTablas(): void{
    this.definicionestecnicasService.getTablasReferencia().subscribe(
      data => {
        this.tablas = data;
      }
    );
  }

  buscar(): void {
    if(this.tablaSeleccionada) {
      this.definicionestecnicasService.getEsquemasOR(this.tablaSeleccionada).subscribe(
        data => {
          this.esquemasOR = data;
        }
      );
      this.definicionestecnicasService.getTablasOR(this.tablaSeleccionada).subscribe(
        data => {
          this.tablasOR = data;
        }
      );
      this.definicionestecnicasService.getCamposOR(this.tablaSeleccionada).subscribe(
        data => {
          this.camposOR = data;
        }
      );
    } else {
      alert('Seleccione una tabla antes de buscar.')
    }
  }
}
