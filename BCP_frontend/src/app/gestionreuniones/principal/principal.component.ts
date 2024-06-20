import { Component, OnInit } from '@angular/core';
import { ReunionesService } from '../../services/reuniones/reuniones.service';
import { RouterLink, RouterOutlet } from '@angular/router';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-principal-reuniones',
  standalone: true,
  imports: [
    RouterOutlet,
    CommonModule,
    RouterLink
  ],
  templateUrl: './principal.component.html',
  styleUrls: ['./principal.component.css']
})
export class PrincipalReunionesComponent implements OnInit {

  pedidos: any[] = [];
  reunionesPendientes: any[] = [];
  reunionesCompletadas: any[] = [];

  constructor(
    private reunionesService: ReunionesService
  ) {}

  ngOnInit(): void {

    this.reunionesService.obtenerReunionesPendientes().subscribe(data => {
      this.reunionesPendientes = data;
    });

    this.reunionesService.obtenerReunionesCompletadas().subscribe(data => {
      this.reunionesCompletadas = data;
    });
  }

}
