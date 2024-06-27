import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, ReactiveFormsModule, Validators} from '@angular/forms';
import {AreasService} from "../../services/areas/areas.service";
import {SquadsService} from "../../services/squads/squads.service";
import {PedidosService} from "../../services/pedidos/pedidos.service";
import {PrioridadesService} from "../../services/prioridades/prioridades.service";
import {RouterLink, RouterOutlet} from '@angular/router';
import {CommonModule} from '@angular/common';

@Component({
  selector: 'app-agregarpedido',
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
  squads: any;
  prioridades: any;

  constructor(
    private fb: FormBuilder,
    public areasService: AreasService,
    public squadService: SquadsService,
    public prioridadesService: PrioridadesService,
    public pedidosService: PedidosService
  ) {
  }

  ngOnInit(): void {
    this.pedidoForm = this.fb.group({
      areaId: ['', Validators.required],
      squadId: ['', Validators.required],
      prioridadId: ['', Validators.required],
      pedidoFechaLimite: ['', Validators.required]
    });

    this.areasService.todoAreas().subscribe(data => {
        this.areas = data;
      });

    this.squadService.todoSquads().subscribe(data => {
        this.squads = data;
      });

    this.prioridadesService.todoPrioridades().subscribe(data => {
        this.prioridades = data;
      });
  }

  guardar(): void {
    const pedidoData = {
      areaId: { areaId: this.pedidoForm.value.areaId },
      squadId: { squadId: this.pedidoForm.value.squadId },
      prioridadId: { prioridadId: this.pedidoForm.value.prioridadId },
      pedidoFechaLimite: this.pedidoForm.value.pedidoFechaLimite
    };

    this.pedidosService.crearPedido(pedidoData).subscribe(

      response => {
        console.log('Pedido creado', response);
      },
      error => {
        console.error('Error al crear el pedido', error);
      }
    );
  }
}
