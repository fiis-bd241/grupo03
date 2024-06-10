import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, ReactiveFormsModule, Validators} from '@angular/forms';
import {PedidosService} from "../../services/pedidos/pedidos.service";
import {RouterLink, RouterOutlet} from '@angular/router';
import {CommonModule} from '@angular/common';
import {MigracionesService} from "../../services/migraciones/migraciones.service";
import {SquadsService} from "../../services/squads/squads.service";
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
  squads: any;
  tecnologias: any;
  pedidos: any;

  constructor(
    private fb: FormBuilder,
    public migracionService: MigracionesService,
    public squadService: SquadsService,
    public tecnologiaService: TecnologiasService,
    public pedidosService: PedidosService
  ) {
  }

  ngOnInit(): void {
    this.migracionForm = this.fb.group({
      pedidoId: ['', Validators.required],
      squadId: ['', Validators.required],
      tecnologiaId: ['', Validators.required]
    });

    this.squadService.todoSquads().subscribe(resp => {
        this.squads = resp;
      },
      error => {
        console.error(error)
      }
    );
    this.tecnologiaService.todoTecnologias().subscribe(resp => {
        this.tecnologias = resp;
      },
      error => {
        console.error(error)
      }
    );
    this.pedidosService.todosPedidos().subscribe(resp => {
        this.pedidos = resp;
      },
      error => {
        console.error(error)
      }
    )
  }

  guardar(): void {
  }
}
