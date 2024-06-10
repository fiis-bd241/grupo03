
import { Component, OnInit } from '@angular/core';
import { FormBuilder, ReactiveFormsModule } from '@angular/forms';
import { PedidosService } from "../../services/pedidos/pedidos.service";
import {RouterLink, RouterOutlet} from '@angular/router';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [
    RouterOutlet,
    ReactiveFormsModule,
    CommonModule,
    RouterLink
  ],
  templateUrl: './verpedidos.component.html',
  styleUrl: './verpedidos.component.css'
})
export class VerpedidosComponent implements OnInit {
  pedidos: any[] = [];

  constructor(
    private fb: FormBuilder,
    public pedidosService: PedidosService
  ) {}

  ngOnInit(): void {
    this.pedidosService.todosPedidos().subscribe(data => {
      this.pedidos = data;
    });
  }
}
