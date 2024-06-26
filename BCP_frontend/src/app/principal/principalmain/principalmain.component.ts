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
  templateUrl: './principalmain.component.html',
  styleUrls: ['./principalmain.component.css']
})
export class PrincipalmainComponent implements OnInit {
  pedidos: any[] = [];
  migraciones: any[] = [];

  constructor(
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
