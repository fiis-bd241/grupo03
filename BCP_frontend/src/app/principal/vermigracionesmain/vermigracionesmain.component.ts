import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, ReactiveFormsModule, Validators} from '@angular/forms';
import { MigracionesService } from '../../services/migraciones/migraciones.service';
import {NgForOf, NgIf} from '@angular/common';
import {PedidosService} from "../../services/pedidos/pedidos.service";
import {ActivatedRoute, RouterLink} from "@angular/router";

@Component({
  selector: 'app-vermigraciones',
  standalone: true,
  imports: [
    ReactiveFormsModule,
    NgForOf,
    NgIf,
    RouterLink
  ],
  templateUrl: './vermigracionesmain.component.html',
  styleUrl: './vermigracionesmain.component.css'
})
export class VermigracionesmainComponent implements OnInit {
  migracionForm: FormGroup;
  migraciones: any[] = [];
  pedidos: any[] = [];
  pedidoId: number;

  constructor(
    private fb: FormBuilder,
    private route: ActivatedRoute,
    private migracionesService: MigracionesService,
    private pedidosService: PedidosService
  ) { }

  ngOnInit(): void {
    this.migracionForm = this.fb.group({
      pedidoId: ['', Validators.required]
    });

    this.route.params.subscribe(params => {
      this.pedidoId = +params['pedidoId'];
      this.migracionForm.patchValue({ pedidoId: this.pedidoId });
      this.buscar();
    });

    this.pedidosService.todosPedidosId().subscribe(data => {
      this.pedidos = data;
    })
  }

  buscar(): void {
    const pedidoId = this.migracionForm.value.pedidoId;
    this.migracionesService.buscarMigracionesPorPedidoId(pedidoId).subscribe(response => {
      this.migraciones = response;
      console.log('Migraciones obtenidas', response);
    });
  }
}
