import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ReunionesService } from '../../services/reuniones/reuniones.service';
import {PedidosService} from "../../services/pedidos/pedidos.service";
import {EmpleadosService} from "../../services/empleados/empleados.service";
import {TiposreunionService} from "../../services/tiposreunion/tiposreunion.service";

@Component({
  selector: 'app-crear-reunion',
  templateUrl: './crear-reunion.component.html',
  standalone: true,
  styleUrls: ['./crear-reunion.component.css']
})
export class CrearReunionComponent implements OnInit {
  formularioReunion: FormGroup;
  tiposReunion: string[] = [];
  pedidos: any[] = [];
  empleados: string[] = [];
  participantes: number[] = [];

  constructor(
    private formBuilder: FormBuilder,
    private reunionesService: ReunionesService,
    private pedidosService: PedidosService,
    private empleadosService: EmpleadosService,
    private tiposReunionService: TiposreunionService
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
      tipoReunion: ['', Validators.required],
      participantes: [[]]
    });

    this.tiposReunionService.todosTiposReunionNombres().subscribe(data => {
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
      const nuevaReunion = {
        pedidoId: this.formularioReunion.value.pedidoId,
        empleadoId: this.formularioReunion.value.empleadoId,
        fecha: this.formularioReunion.value.fecha,
        horaInicio: this.formularioReunion.value.horaInicio,
        horaFin: this.formularioReunion.value.horaFin,
        plataforma: this.formularioReunion.value.plataforma,
        agenda: this.formularioReunion.value.agenda,
        tipoReunion: this.formularioReunion.value.tipoReunion,
        participanteIds: this.formularioReunion.value.participantes
      };

     // this.reunionesService.crearReunionConParticipantes(nuevaReunion).subscribe(response => {
      //  console.log('Reunión creada:', response);
        //this.formularioReunion.reset();
     // });
    }
  }

}
