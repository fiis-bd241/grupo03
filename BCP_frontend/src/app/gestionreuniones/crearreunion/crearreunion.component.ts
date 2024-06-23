import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { ReunionesService } from '../../services/reuniones/reuniones.service';
import { PedidosService } from '../../services/pedidos/pedidos.service';
import { EmpleadosService } from '../../services/empleados/empleados.service';
import { TiposreunionService } from '../../services/tiposreunion/tiposreunion.service';
import { Router, RouterLink, RouterOutlet } from '@angular/router';
import { CommonModule } from "@angular/common";

@Component({
  selector: 'app-crearreunion',
  templateUrl: './crearreunion.component.html',
  standalone: true,
  imports: [
    RouterOutlet,
    ReactiveFormsModule,
    CommonModule,
    RouterLink,
  ],
  styleUrls: ['./crearreunion.component.css']
})
export class CrearReunionComponent implements OnInit {
  formularioReunion: FormGroup;
  tiposReunion: any[] = [];
  pedidos: any[] = [];
  empleados: any[] = [];

  constructor(
    private formBuilder: FormBuilder,
    private reunionesService: ReunionesService,
    private pedidosService: PedidosService,
    private empleadosService: EmpleadosService,
    private tiposreunionService: TiposreunionService,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.formularioReunion = this.formBuilder.group({
      pedidoId: ['', Validators.required],
      empleadoId: ['', Validators.required],
      fecha: ['', Validators.required],
      horaInicio: ['', Validators.required],
      horaFin: ['', Validators.required],
      plataforma: ['', Validators.required],
      agenda: [''],
      tipoReunion: ['', Validators.required]
    });

    this.tiposreunionService.todosTiposReunionNombres().subscribe(data => {
      this.tiposReunion = data;
    });

    this.pedidosService.todosPedidosId().subscribe(data => {
      this.pedidos = data;
    });

    this.empleadosService.todosProductOwner().subscribe(data => {
      this.empleados = data;
    });
  }

  onSubmit(): void {
    if (this.formularioReunion.valid) {
      const reunionParcial = this.formularioReunion.value;
      this.siguientePaso(reunionParcial);
    }
  }

  siguientePaso(reunionParcial: any): void {
    sessionStorage.setItem('reunionParcial', JSON.stringify(reunionParcial));
    this.router.navigate(['/paso2']);
  }
}
