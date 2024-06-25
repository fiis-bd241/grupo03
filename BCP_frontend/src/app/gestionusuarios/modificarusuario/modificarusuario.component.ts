import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { EmpleadosService } from '../../services/empleados/empleados.service';
import { Router } from '@angular/router';
import { CommonModule } from '@angular/common';
import { ReactiveFormsModule } from '@angular/forms';
import { RouterLink, RouterOutlet } from '@angular/router';

@Component({
  selector: 'app-modificar-usuario',
  standalone: true,
  imports: [
    RouterOutlet,
    ReactiveFormsModule,
    CommonModule,
    RouterLink,
  ],
  templateUrl: './modificarusuario.component.html',
  styleUrls: ['./modificarusuario.component.css']
})
export class ModificarusuarioComponent implements OnInit {
  modificarUsuarioForm: FormGroup;
  usuarios: any[] = [];
  usuarioLogeado: string;
  now: Date = new Date();

  constructor(
    private fb: FormBuilder,
    private empleadosService: EmpleadosService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.modificarUsuarioForm = this.fb.group({
      nombre: ['', Validators.required]
    });

    this.setUsuarioLogeado();

    this.empleadosService.obtenerTodosLosUsuarios().subscribe(data => {
      this.usuarios = data;
    });

    setInterval(() => {
      this.now = new Date();
    }, 1000);
  }

  onSubmit() {
    if (this.modificarUsuarioForm.valid) {
      const nombre = this.modificarUsuarioForm.value.nombre;

      this.empleadosService.actualizarContrasena(nombre).subscribe(
        response => {
          console.log('Contraseña actualizada:', response);
          alert('Contraseña actualizada exitosamente.');
        },
        error => {
          console.error('Error al actualizar contraseña:', error);
          alert('Error al actualizar contraseña. Verifique los datos e intente nuevamente.');
        }
      );
    } else {
      console.error('Formulario no válido');
    }
  }

  setUsuarioLogeado(): void {
    const usuario = localStorage.getItem('usuarioLogeado');
    if (usuario) {
      this.usuarioLogeado = usuario;
    } else {
      this.usuarioLogeado = 'Usuario no identificado';
    }
  }
}
