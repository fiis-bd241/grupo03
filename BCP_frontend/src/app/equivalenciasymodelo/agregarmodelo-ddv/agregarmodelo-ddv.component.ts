import { Component, OnInit } from '@angular/core';
import { ModeladoService } from '../../services/modelado/modelado.service';
import { DefinicionestecnicasService } from '../../services/definicionestecnicas/definicionestecnicas.service';
import { FormBuilder, FormGroup, Validators, ReactiveFormsModule } from '@angular/forms';
import { RouterLink, RouterOutlet } from '@angular/router';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-agregarmodelo-ddv',
  standalone: true,
  imports: [
    RouterOutlet,
    CommonModule,
    RouterLink,
    ReactiveFormsModule
  ],
  templateUrl: './agregarmodelo-ddv.component.html',
  styleUrls: ['./agregarmodelo-ddv.component.css']
})
export class AgregarmodeloDdvComponent implements OnInit {
  modeloForm: FormGroup;
  asociarForm: FormGroup;
  camposDisponibles: string[] = [];
  campoSeleccionado: string = '';

  constructor(
    private fb: FormBuilder,
    public modeloService: ModeladoService,
    public definicionestecnicasService: DefinicionestecnicasService
  ) {}

  ngOnInit(): void {
    this.modeloForm = this.fb.group({
      campo: ['', Validators.required],
      campoDDV: ['', Validators.required],
      campoLlave: [false, Validators.required],
      campoDescarta: [false, Validators.required]
    });

    this.asociarForm = this.fb.group({
      esquemaDDV: ['', Validators.required],
      tablaDDV: ['', Validators.required]
    });

    this.cargarCamposDisponibles();
  }

  cargarCamposDisponibles(): void {
    this.definicionestecnicasService.getCamposEquivalentes().subscribe(
      campos => {
        this.camposDisponibles = campos;
      }
    );
  }

  guardar(): void {
    if (this.modeloForm.valid) {
      const { campo, campoDDV, campoLlave, campoDescarta } = this.modeloForm.value;
      this.modeloService.crearModelo(campo, campoDDV, campoLlave, campoDescarta).subscribe(() => {
        console.log('Modelo insertado correctamente');
      });
    }
  }

  asociar(): void {
    if (this.asociarForm.valid) {
      const { esquemaDDV, tablaDDV } = this.asociarForm.value;
      const campo = this.modeloForm.get('campo').value; // Obtener el campo seleccionado
      this.modeloService.actualizarEsquemaTabla(campo, esquemaDDV, tablaDDV).subscribe(() => {
        console.log('Esquema y tabla actualizados correctamente');
      });
    }
  }
}


