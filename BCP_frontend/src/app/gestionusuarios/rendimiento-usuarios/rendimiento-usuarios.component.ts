import { Component, OnInit } from '@angular/core';
import { EmpleadosService } from '../../services/empleados/empleados.service';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { RouterLink, RouterOutlet } from '@angular/router';

@Component({
  selector: 'app-rendimiento-usuarios',
  standalone: true,
  imports: [
    CommonModule,
    FormsModule,
    RouterLink,
    RouterOutlet
  ],
  templateUrl: './rendimiento-usuarios.component.html',
  styleUrls: ['./rendimiento-usuarios.component.css']
})
export class RendimientoUsuariosComponent implements OnInit {
  usuarios: any[] = [];
  filteredUsuarios: any[] = [];
  usuarioLogeado: string;
  now: Date = new Date();
  filterEmpleado: string = '';
  filterFechaInicio: string = '';
  filterFechaFin: string = '';

  constructor(private empleadosService: EmpleadosService) { }

  ngOnInit(): void {
    this.empleadosService.obtenerRendimientoUsuarios().subscribe(data => {
      this.usuarios = data;
      this.filteredUsuarios = data;
      this.setUsuarioLogeado();
    });

    setInterval(() => {
      this.now = new Date();
    }, 1000);
  }

  setUsuarioLogeado(): void {
    const usuario = localStorage.getItem('usuarioLogeado');
    if (usuario) {
      this.usuarioLogeado = usuario;
    } else {
      this.usuarioLogeado = 'Usuario no identificado';
    }
  }

  applyFilter(): void {
    this.filteredUsuarios = this.usuarios.filter(usuario => {
      const matchEmpleado = this.filterEmpleado ? usuario.empleado.toLowerCase().includes(this.filterEmpleado.toLowerCase()) : true;
      const matchFechaInicio = this.filterFechaInicio ? new Date(usuario.fecha) >= new Date(this.filterFechaInicio) : true;
      const matchFechaFin = this.filterFechaFin ? new Date(usuario.fecha) <= new Date(this.filterFechaFin) : true;
      return matchEmpleado && matchFechaInicio && matchFechaFin;
    });
  }

  resetFilter(): void {
    this.filterEmpleado = '';
    this.filterFechaInicio = '';
    this.filterFechaFin = '';
    this.filteredUsuarios = this.usuarios;
  }
}
