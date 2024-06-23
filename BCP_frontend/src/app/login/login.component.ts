import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { AutenticacionService } from '../services/autenticacion/autenticacion.service';
import { Router } from '@angular/router';
import { ReactiveFormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { RouterLink, RouterOutlet } from '@angular/router';


@Component({
  selector: 'app-login',
  standalone: true,
  imports: [
    RouterOutlet,
    ReactiveFormsModule,
    CommonModule,
    RouterLink,
  ], 
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  loginForm: FormGroup;

  constructor(
    private fb: FormBuilder,
    private authService: AutenticacionService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.loginForm = this.fb.group({
      loginType: ['numero', Validators.required],
      dni: ['', Validators.required],
      alias: [''],
      contrasena: ['', Validators.required]
    });

    this.loginForm.get('loginType').valueChanges.subscribe(value => {
      const dniControl = this.loginForm.get('dni');
      const aliasControl = this.loginForm.get('alias');

      if (value === 'numero') {
        dniControl.setValidators([Validators.required]);
        aliasControl.clearValidators();
      } else {
        aliasControl.setValidators([Validators.required]);
        dniControl.clearValidators();
      }

      dniControl.updateValueAndValidity();
      aliasControl.updateValueAndValidity();
    });
  }

  onSubmit() {
    const loginData = this.loginForm.value.loginType === 'numero'
      ? this.loginForm.value.dni
      : this.loginForm.value.alias;

    this.authService.login(loginData, this.loginForm.value.contrasena).subscribe(
      response => {
        console.log('Login successful', response);
        localStorage.setItem('isLoggedIn', 'true');
        this.router.navigate(['/principal']);
      },
      error => {
        console.error('Login failed', error);
        alert('Credenciales incorrectas, por favor intente de nuevo');
      }
    );
  }
}
