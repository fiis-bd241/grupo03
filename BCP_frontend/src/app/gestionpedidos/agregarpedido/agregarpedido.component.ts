import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, ReactiveFormsModule, Validators} from '@angular/forms';
import {AreasService} from "../../services/areas/areas.service";
import {EstadosService} from "../../services/estados/estados.service";
import {PedidosService} from "../../services/pedidos/pedidos.service";
import {PrioridadesService} from "../../services/prioridades/prioridades.service";
import {RouterLink, RouterOutlet} from '@angular/router';
import {CommonModule} from '@angular/common';



@Component({
  selector: 'app-root',
  standalone: true,
  imports: [
    RouterOutlet,
    ReactiveFormsModule,
    CommonModule,
    RouterLink,
  ],
  templateUrl: './agregarpedido.component.html',
  styleUrls: ['./agregarpedido.component.css']
})
export class AgregarpedidoComponent implements OnInit {
  pedidoForm: FormGroup;
  areas: any;
  prioridades: any;
  estados: any;

  constructor(
    private fb: FormBuilder,
    public areasService: AreasService,
    public prioridadesService: PrioridadesService,
    public estadosService: EstadosService,
    public pedidosService: PedidosService
  ) {
  }

  ngOnInit(): void {
    this.pedidoForm = this.fb.group({
      areaId: ['', Validators.required],
      prioridadId: ['', Validators.required],
      estadoId: ['', Validators.required],
      pedidoFechaLimite: ['', Validators.required]
    });

    this.areasService.todoAreas().subscribe(resp => {
        this.areas = resp;
      },
      error => {
        console.error(error)
      }
    );
    this.estadosService.todoEstados().subscribe(resp => {
        this.estados = resp;
      },
      error => {
        console.error(error)
      }
    );
    this.prioridadesService.todoPrioridades().subscribe(resp => {
        this.prioridades = resp;
      },
      error => {
        console.error(error)
      }
    )
  }

  guardar(): void {
  }
}


