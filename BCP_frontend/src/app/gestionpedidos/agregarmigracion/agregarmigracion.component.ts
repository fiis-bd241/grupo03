import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, ReactiveFormsModule, Validators} from '@angular/forms';
import {PedidosService} from "../../services/pedidos/pedidos.service";
import {RouterLink, RouterOutlet} from '@angular/router';
import {CommonModule} from '@angular/common';
import {MigracionesService} from "../../services/migraciones/migraciones.service";
import {AmbientesService} from "../../services/ambientes/ambientes.service";
import {TecnologiasService} from "../../services/tecnologias/tecnologias.service";


@Component({
  selector: 'app-root',
  standalone: true,
  imports: [
    RouterOutlet,
    ReactiveFormsModule,
    CommonModule,
    RouterLink,
  ],
  templateUrl: './agregarmigracion.component.html',
  styleUrl: './agregarmigracion.component.css'
})
export class AgregarmigracionComponent implements OnInit {
  migracionForm: FormGroup;
  ambientes: any;
  tecnologias: any;
  pedidos: any;

  constructor(
    private fb: FormBuilder,
    public migracionService: MigracionesService,
    public ambientesService: AmbientesService,
    public tecnologiaService: TecnologiasService,
    public pedidosService: PedidosService
  ) {
  }

  ngOnInit(): void {
    this.migracionForm = this.fb.group({
      pedidoId: ['', Validators.required],
      ambienteId: ['', Validators.required],
      tecnologiaId: ['', Validators.required]
    });

    this.ambientesService.todoAmbientes().subscribe(data => {
        this.ambientes = data;
      });

    this.tecnologiaService.todoTecnologias().subscribe(data => {
        this.tecnologias = data;
      });

    this.pedidosService.todosPedidosId().subscribe(data => {
        this.pedidos = data;
      })
  }

  guardar(): void {
    const migracionData = {
      pedidoId: { pedidoId: this.migracionForm.value.pedidoId },
      ambienteId: { ambienteId: this.migracionForm.value.ambienteId },
      tecnologiaId: { tecnologiaId: this.migracionForm.value.tecnologiaId }
    };

    this.migracionService.crearMigracion(migracionData).subscribe(

      response => {
        console.log('Migración creado', response);
      },
      error => {
        console.error('Error al crear la migración', error);
      }
    );
  }
}
