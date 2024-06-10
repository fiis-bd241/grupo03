import { Component, OnInit } from '@angular/core';
import { FormBuilder, ReactiveFormsModule } from '@angular/forms';
import { PedidosService } from "../../services/pedidos/pedidos.service";
import {RouterLink, RouterOutlet} from '@angular/router';
import { CommonModule } from '@angular/common';
import { MigracionesService } from "../../services/migraciones/migraciones.service";

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [
    RouterOutlet,
    ReactiveFormsModule,
    CommonModule,
    RouterLink
  ],
  templateUrl: './principal.component.html',
  styleUrls: ['./principal.component.css']
})
export class PrincipalComponent implements OnInit {
  pedidos: any[] = [];
  migraciones: any[] = [];

  constructor(
    private fb: FormBuilder,
    public pedidosService: PedidosService,
    public migracionesService: MigracionesService
  ) {}

  ngOnInit(): void {
    this.pedidosService.getTop3Pedidos().subscribe(data => {
      this.pedidos = data;
    });

    this.migracionesService.getTop3Migraciones().subscribe(data => {
      this.migraciones = data;
    });
  }
}
