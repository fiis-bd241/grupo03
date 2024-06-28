import { Component } from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {ModeladoService} from "../../services/modelado/modelado.service";
import {RegladecargafuncionalService} from "../../services/regladecargafuncional/regladecargafuncional.service";
import {NgForOf, NgIf} from "@angular/common";

@Component({
  selector: 'app-verreglafuncional',
  standalone: true,
  imports: [
    NgForOf,
    NgIf
  ],
  templateUrl: './verreglafuncional.component.html',
  styleUrl: './verreglafuncional.component.css'
})
export class VerreglafuncionalComponent {

  reglasfunc: any[];

  constructor(
    private route: ActivatedRoute,
    private regladecargafuncionalService : RegladecargafuncionalService
  ) {}

  ngOnInit(): void {
    this.buscar();
  }

  buscar(): void {
    this.route.params.subscribe(params => {
      let migracionId = +params['migracionId'];
      this.regladecargafuncionalService.buscarReglaFuncPorMigracion(migracionId).subscribe(response => {
        this.reglasfunc = response;
        console.log('Regla funcional obtenida:', response);
      }, error => {
        console.error('Error al obtener Regla Funcional', error);
      });
    });
  }
}
