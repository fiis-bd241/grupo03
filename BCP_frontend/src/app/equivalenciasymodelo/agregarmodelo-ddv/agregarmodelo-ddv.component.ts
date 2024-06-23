import { Component, OnInit} from '@angular/core';
import {ModeladoService} from "../../services/modelado/modelado.service";
import {DefinicionestecnicasService} from "../../services/definicionestecnicas/definicionestecnicas.service";
import {FormBuilder, FormGroup, ReactiveFormsModule, Validators} from '@angular/forms';
import {RouterLink, RouterOutlet} from '@angular/router';
import {CommonModule} from '@angular/common';


@Component({
  selector: 'app-agregarmodelo-ddv',
  standalone: true,
  imports: [
    RouterOutlet,
    ReactiveFormsModule,
    CommonModule,
    RouterLink,
  ],
  templateUrl: './agregarmodelo-ddv.component.html',
  styleUrl: './agregarmodelo-ddv.component.css'
})
export class AgregarmodeloDdvComponent implements OnInit{
  campos: string [] =  [];
  modeloForm : FormGroup;
  campoDDV: any;
  campoLlave: any;
  campoDescartado: any;
  esquemaDDV: any;
  tablaDDV: any;

  constructor(
    private fb: FormBuilder,
    public modeladoService: ModeladoService,
    public definicionesTecnicasService: DefinicionestecnicasService
  ) {}

  ngOnInit(): void {
    this.modeloForm = this.fb.group( {
      campo: ['', Validators.required],
      campoDDV: ['', Validators.required],
      campoLlave: [false, Validators.required],
      campoDescartado: [false, Validators.required],
      esquemaDDV: ['', Validators.required],
      tablaDDV: ['', Validators.required]
    });

    this.cargarCamposEquivalentes();
  }

  cargarCamposEquivalentes(): void{
    this.definicionesTecnicasService.getCamposEquivalentes().subscribe(
      data => {
        this.campos = data;
      }
    );
  }

  guardarModelo(): void{
    const {campoDDV, campoLlave, campoDescartado, campo} = this.modeloForm.value;
    this.modeladoService.crearModelo(campoDDV, campoLlave, campoDescartado, campo).subscribe(
      response => {
        alert('Modelo guardado correctamente');
      }
    );
  }

  asociarEsquemaTabla(): void{
    const {esquemaDDV, tablaDDV, campo} = this.modeloForm.value;
    this.modeladoService.actualizarEsquemaTabla(esquemaDDV, tablaDDV, campo).subscribe(
      response => {
        alert('Esquema y tabla asociados correctamente');
      }
    );
  }
}
