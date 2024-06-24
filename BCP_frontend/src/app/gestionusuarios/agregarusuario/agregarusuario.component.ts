import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { EmpleadosService } from '../../services/empleados/empleados.service';
import { Router } from '@angular/router';
import { CommonModule } from '@angular/common';
import { ReactiveFormsModule } from '@angular/forms';
import { RouterLink, RouterOutlet } from '@angular/router';

@Component({
  selector: 'app-agregar-usuario',
  standalone: true,
  imports: [
    RouterOutlet,
    ReactiveFormsModule,
    CommonModule,
    RouterLink,
  ],
  templateUrl: './agregarusuario.component.html',
  styleUrls: ['./agregarusuario.component.css']
})
export class AgregarUsuarioComponent implements OnInit {
  usuarioForm: FormGroup;
  roles: string[] = ['System Admin', 'Data Engineer', 'Data Governance Expert', 'Data Steward', 'Data Steward Senior', 'Custodio Técnico', 'Product Owner', 'Data Modeler'];
  usuarioLogeado: string;
  now: Date = new Date();

  constructor(
    private fb: FormBuilder,
    private empleadosService: EmpleadosService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.usuarioForm = this.fb.group({
      nombre: ['', Validators.required],
      rol: ['', Validators.required],
      correo: ['', [Validators.required]],
      telefono: ['', Validators.required],
      dni: ['', Validators.required]
    });

    this.setUsuarioLogeado();
    
    setInterval(() => {
      this.now = new Date();
    }, 1000);
  }

  onSubmit() {
    if (this.usuarioForm.valid) {
      const nuevoUsuario = {
        nombre: this.usuarioForm.value.nombre,
        rol: { nombreRol: this.usuarioForm.value.rol },
        correo: this.usuarioForm.value.correo,
        telefono: this.usuarioForm.value.telefono,
        dni: this.usuarioForm.value.dni
      };
  
      console.log('Usuario agregado:', nuevoUsuario.nombre);
      this.empleadosService.agregarUsuario(nuevoUsuario).subscribe({
        next: response => {
          console.log('Usuario guardado:', response);
          this.router.navigate(['/gestion/usuarios']);
        },
        error: error => {
          console.error('Error al agregar usuario:', error);
          alert('Error al agregar usuario. Verifique los datos e intente nuevamente.');
        }
      });
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
