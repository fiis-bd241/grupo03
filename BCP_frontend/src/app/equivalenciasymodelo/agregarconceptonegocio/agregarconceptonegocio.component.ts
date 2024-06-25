import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, ReactiveFormsModule, Validators} from "@angular/forms";
import {InsertDataService} from "../../services/insertData/insert-data.service";
import {DominiosService} from "../../services/dominios/dominios.service";
import {SubdominiosService} from "../../services/subdominios/subdominios.service";
import {AmbientesService} from "../../services/ambientes/ambientes.service";
import {EsquemasService} from "../../services/esquemas/esquemas.service";
import {RouterLink, RouterOutlet} from '@angular/router';
import {CommonModule} from '@angular/common';

@Component({
  selector: 'app-agregarconceptonegocio',
  standalone: true,
  imports: [
    ReactiveFormsModule,
    RouterLink,
    RouterOutlet,
    CommonModule
  ],
  templateUrl: './agregarconceptonegocio.component.html',
  styleUrl: './agregarconceptonegocio.component.css'
})
export class AgregarconceptonegocioComponent implements OnInit{
  insertForm: FormGroup;
  dominios: any;
  subdominios: any;
  esquemas: any;
  ambientes:any;

  constructor(
    private fb:FormBuilder,
    public insertDataService: InsertDataService,
    public dominioService: DominiosService,
    public subdominioService: SubdominiosService,
    public ambienteService: AmbientesService,
    public esquemaService: EsquemasService
  ) {}

  ngOnInit():void{
    this.insertForm = this.fb.group({
      dominio: ['', Validators.required],
      subdominio: ['', Validators.required],
      ambiente: ['', Validators.required],
      esquema: ['', Validators.required],
      campo: ['', Validators.required],
      definicion: ['', Validators.required],
      campoEquivalente: ['', Validators.required],
      esquemaEquivalente: ['', Validators.required],
    });

    this.dominioService.todoDominios().subscribe(data=>{
      this.dominios = data;
    });

    this.ambienteService.todoAmbientes().subscribe(data=>{
      this.ambientes = data;
    });

  }

  cargarSubdominios(event): void{
    this.subdominioService.todoSudominios(event.target.value).subscribe(data=>{
      this.subdominios = data;
    });
  }

  cargarEsquemas(event): void{
    this.esquemaService.todoEsquemas(event.target.value).subscribe(data=>{
      this.esquemas = data;
    });
  }

  guardar(): void {
    if (this.insertForm.valid) {
      this.insertDataService.insertData(
        this.insertForm.value.esquema,             // esquemaId1
        this.insertForm.value.campo,               // campo1
        this.insertForm.value.esquemaEquivalente,  // esquemaId2
        this.insertForm.value.campoEquivalente,    // campo2
        this.insertForm.value.subdominio,          // subdominioId
        this.insertForm.value.definicion           // definicionCampo
      ).subscribe(() => {
          console.log('Datos guardados exitosamente');
        },
        error => {
          console.error('Error al guardar los datos', error);
        }
      );
    } else {
      console.error('Formulario inválido');
    }
  }

  agregarOtraInsercion() : void{
    console.log('Se ha hecho click en el botón "+"');
  }
}
