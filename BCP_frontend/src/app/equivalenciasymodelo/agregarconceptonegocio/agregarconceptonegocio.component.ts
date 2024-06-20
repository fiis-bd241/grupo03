import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, ReactiveFormsModule, Validators} from "@angular/forms";
import {DominiosService} from "../../services/dominios/dominios.service";
import {AmbientesService} from "../../services/ambientes/ambientes.service";
import {SubdominiosService} from "../../services/subdominios/subdominios.service";
import {EsquemasService} from "../../services/esquemas/esquemas.service";
import {RouterOutlet} from "@angular/router";

@Component({
  selector: 'app-agregarconceptonegocio',
  standalone: true,
  imports: [
    ReactiveFormsModule,
    RouterOutlet
  ],
  templateUrl: './agregarconceptonegocio.component.html',
  styleUrl: './agregarconceptonegocio.component.css'
})
export class AgregarconceptonegocioComponent implements OnInit{

  conceptonegocioForm: FormGroup;

  constructor(
    public fb: FormBuilder,
    public dominiosService: DominiosService,
    public ambientesService: AmbientesService,
    public subdominiosService: SubdominiosService,
    public esquemasService: EsquemasService
  ){
  }

  ngOnInit(): void {

    this.conceptonegocioForm = this.fb.group({
      idDominio: ['', Validators.required],
      idSubdominio : ['', Validators.required],
      idAmbiente : ['', Validators.required],
      idEsquema: ['', Validators.required],
    })
  }

  guardar():void{

  }

}
