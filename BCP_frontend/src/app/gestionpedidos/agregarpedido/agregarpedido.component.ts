import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, ReactiveFormsModule, Validators} from '@angular/forms';
import {AreasService} from "../../services/areas/areas.service";
import {EstadosService} from "../../services/estados/estados.service";
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
  prioridades: any;
  estados: any;

  constructor(
    private fb: FormBuilder,
    public areasService: AreasService,
    public prioridadesService: PrioridadesService,
    public estadosService: EstadosService,
    public pedidosService: PedidosService
  ) {}

  ngOnInit(): void {
    this.pedidoForm = this.fb.group({
      areaId: ['', Validators.required],
      prioridadId: ['', Validators.required],
      estadoId: ['', Validators.required],
      pedidoFechaLimite: ['', Validators.required]
    });

    this.areasService.todoAreas().subscribe(data => {
        this.areas = data;
      });

    this.estadosService.todoEstados().subscribe(data => {
        this.estados = data;
      });

    this.prioridadesService.todoPrioridades().subscribe(data => {
        this.prioridades = data;
      });
  }

  guardar(): void {
    const pedidoData = {
      areaId: { areaId: this.pedidoForm.value.areaId },
      prioridadId: { prioridadId: this.pedidoForm.value.prioridadId },
      estadoId: { estadoId: this.pedidoForm.value.estadoId },
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
