import { Component, OnInit } from '@angular/core';
import { FormBuilder, ReactiveFormsModule } from '@angular/forms';
import {RouterLink, RouterOutlet} from '@angular/router';
import { CommonModule } from '@angular/common';
import {FormsModule} from "@angular/forms";
import {DefinicionestecnicasService} from "../../services/definicionestecnicas/definicionestecnicas.service";
import {ModeladoService} from "../../services/modelado/modelado.service";

@Component({
  selector: 'app-vermodelo-ddv',
  standalone: true,
  imports: [
    RouterOutlet,
    ReactiveFormsModule,
    CommonModule,
    RouterLink,
    FormsModule
  ],
  templateUrl: './vermodelo-ddv.component.html',
  styleUrl: './vermodelo-ddv.component.css'
})
export class VermodeloDDVComponent implements OnInit{
  campos: string[] = [];
  campoSeleccionado: string = '';
  modelo: any;

  constructor(
    public definicionestecnicasService: DefinicionestecnicasService,
    public modeladoService: ModeladoService
  ) {}

  ngOnInit() {
    this.cargarCampos();
  }

  cargarCampos(): void {
    this.definicionestecnicasService.getCamposEquivalentes().subscribe(
      data => {
        this.campos = data;
      }
    );
  }

  buscar(): void {
    if(this.campoSeleccionado){
      this.modeladoService.getModelo(this.campoSeleccionado).subscribe(
        data => {
          this.modelo = data;
        }
      )
    } else {
      alert ('Seleccione campo antes de buscar.')
    }
  }
}
