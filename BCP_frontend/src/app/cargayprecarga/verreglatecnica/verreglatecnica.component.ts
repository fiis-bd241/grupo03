import { Component } from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {ModeladoService} from "../../services/modelado/modelado.service";
import {RegladecargatecnicaService} from "../../services/regladecargatecnica/regladecargatecnica.service";
import {NgForOf, NgIf} from "@angular/common";

@Component({
  selector: 'app-verreglatecnica',
  standalone: true,
  imports: [
    NgForOf,
    NgIf
  ],
  templateUrl: './verreglatecnica.component.html',
  styleUrl: './verreglatecnica.component.css'
})
export class VerreglatecnicaComponent {
  reglastecnicas: any[];

  constructor(
    private route: ActivatedRoute,
    private regladecargatecnicaService : RegladecargatecnicaService
  ) {}

  ngOnInit(): void {
    this.buscar();
  }

  buscar(): void {
    this.route.params.subscribe(params => {
      let migracionId = +params['migracionId'];
      this.regladecargatecnicaService.reglaTecnicaPorMigracion(migracionId).subscribe(response => {
        this.reglastecnicas = response;
        console.log('Reglas técnicas obtenidas:', response);
      }, error => {
        console.error('Error al obtener Reglas técnicas:', error);
      });
    });
  }

}
