import { Component, OnInit } from '@angular/core';
import { EmpleadosService } from '../../services/empleados/empleados.service';
import { CommonModule } from '@angular/common';
import { ReactiveFormsModule } from '@angular/forms';
import { RouterLink, RouterOutlet } from '@angular/router';

@Component({
  selector: 'app-listausuarios',
  standalone: true,
  imports: [
    CommonModule,
    ReactiveFormsModule,
    RouterLink,
    RouterOutlet
  ],
  templateUrl: './listausuarios.component.html',
  styleUrls: ['./listausuarios.component.css']
})
export class ListaUsuariosComponent implements OnInit {
  usuarios: any[] = [];
  usuarioLogeado: string;
  now: Date = new Date();

  constructor(private empleadosService: EmpleadosService) { }

  ngOnInit(): void {
    this.empleadosService.obtenerTodosLosUsuarios().subscribe(data => {
      this.usuarios = data;
      this.setUsuarioLogeado();
    });
    
    setInterval(() => {
      this.now = new Date();
    }, 1000);
  }

  setUsuarioLogeado(): void {
    // Suponiendo que el usuario logeado se almacena en localStorage
    const usuario = localStorage.getItem('usuarioLogeado');
    if (usuario) {
      this.usuarioLogeado = usuario;
    } else {
      this.usuarioLogeado = 'Usuario no identificado';
    }
  }
}
