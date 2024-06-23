import { Component, OnInit } from '@angular/core';
import { ListaUsuariosService } from '../../services/gestion/listausuarios.service';
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
  now: Date = new Date(); // Definir la propiedad now

  constructor(private listaUsuariosService: ListaUsuariosService) {}

  ngOnInit(): void {
    this.listaUsuariosService.obtenerTodosLosUsuarios().subscribe(data => {
      this.usuarios = data;
    });
    
    // Actualizar la hora actual cada segundo
    setInterval(() => {
      this.now = new Date();
    }, 1000);
  }
}
