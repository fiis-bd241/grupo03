import { Component } from '@angular/core';
import { AutenticacionService } from '../services/autenticacion/autenticacion.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  dni: string;
  contrasena: string;

  constructor(private authService: AutenticacionService, private router: Router) { }

  onSubmit() {
    this.authService.login(this.dni, this.contrasena).subscribe(
      response => {
        console.log('Login successful', response);
        this.router.navigate(['/principal']);
      },
      error => {
        console.error('Login failed', error);
        alert('Credenciales incorrectas, por favor intente de nuevo');
      }
    );
  }
}
