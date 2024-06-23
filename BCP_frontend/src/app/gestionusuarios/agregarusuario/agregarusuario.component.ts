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
      correo: ['', [Validators.required, Validators.email]],
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
      const nuevoUsuario = this.usuarioForm.value;
      console.log('Usuario agregado:', nuevoUsuario);
      // Aquí puedes llamar al servicio para guardar el usuario
      // this.empleadosService.agregarUsuario(nuevoUsuario).subscribe(response => {
      //   console.log('Usuario guardado:', response);
      //   this.router.navigate(['/gestion/usuarios']);
      // });
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
