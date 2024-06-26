import {Component, OnInit} from '@angular/core';
import {ConceptosnegocioService} from "../../services/conceptosnegocio/conceptosnegocio.service";
import { FormBuilder, ReactiveFormsModule } from '@angular/forms';
import {RouterLink, RouterOutlet} from '@angular/router';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-vertodo-conceptos',
  standalone: true,
  imports: [
    RouterOutlet,
    RouterLink,
    CommonModule,
    ReactiveFormsModule
  ],
  templateUrl: './vertodo-conceptos.component.html',
  styleUrl: './vertodo-conceptos.component.css'
})
export class VertodoConceptosComponent implements OnInit{
  conceptos: any[] = [];

  constructor(
    public conceptoNegocioservice: ConceptosnegocioService,
  ) {}

  ngOnInit() {
    this.conceptoNegocioservice.todoConceptos().subscribe(data => {
      this.conceptos = data;
    });
  }

}
