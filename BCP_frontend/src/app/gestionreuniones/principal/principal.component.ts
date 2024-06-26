import { Component, OnInit } from '@angular/core';
import { ReunionesService } from '../../services/reuniones/reuniones.service';
import {Router, RouterOutlet} from '@angular/router';
import { FormBuilder, FormGroup, ReactiveFormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import {PedidosService} from "../../services/pedidos/pedidos.service";

@Component({
  selector: 'app-principal-reuniones',
  standalone: true,
  imports: [
    CommonModule,
    ReactiveFormsModule,
    RouterOutlet
  ],
  templateUrl: './principal.component.html',
  styleUrls: ['./principal.component.css']
})
export class PrincipalReunionesComponent implements OnInit {

  pedidos: any[] = [];
  reunionesPendientes: any[] = [];
  reunionesCompletadas: any[] = [];
  searchForm: FormGroup;

  constructor(
    private reunionesService: ReunionesService,
    private pedidosServices: PedidosService,
    private router: Router,
    private fb: FormBuilder
  ) {
    this.searchForm = this.fb.group({
      pedidoId: ['']
    });
  }

  ngOnInit(): void {
    this.reunionesService.obtenerReunionesPendientes().subscribe(data => {
      this.reunionesPendientes = data;
    });

    this.reunionesService.obtenerReunionesCompletadas().subscribe(data => {
      this.reunionesCompletadas = data;
    });

    this.pedidosServices.todosPedidosId().subscribe(data => {
      this.pedidos = data;
    });
  }

  verDetallesPendiente(id: number) {
    this.router.navigate(['/reunion-pendiente', id]);
  }

  verDetallesCompletada(id: number) {
    this.router.navigate(['/reunion-completada', id]);
  }

  buscarReunionesPorPedido(): void {
    const pedidoId = this.searchForm.value.pedidoId;
    if (pedidoId) {
      this.reunionesService.buscarReunionesPendientesPorPedido(pedidoId).subscribe(data => {
        this.reunionesPendientes = data;
      });
      this.reunionesService.buscarReunionesCompletadasPorPedido(pedidoId).subscribe(data => {
        this.reunionesCompletadas = data;
      });
    }
  }
}
