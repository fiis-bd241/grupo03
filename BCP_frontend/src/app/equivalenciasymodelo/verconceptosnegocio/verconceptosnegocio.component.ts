import { Component, OnInit } from '@angular/core';
import {ConceptosnegocioService} from "../../services/conceptosnegocio/conceptosnegocio.service";
import { FormBuilder, ReactiveFormsModule } from '@angular/forms';
import {RouterLink, RouterOutlet} from '@angular/router';
import { CommonModule } from '@angular/common';


@Component({
  selector: 'app-verconceptosnegocio',
  standalone: true,
  imports: [
    RouterOutlet,
    ReactiveFormsModule,
    CommonModule,
    RouterLink
  ],
  templateUrl: './verconceptosnegocio.component.html',
  styleUrl: './verconceptosnegocio.component.css'
})
export class VerconceptosnegocioComponent implements OnInit{
  conceptos: any[] = [];

  constructor(
    public conceptoNegocioservice: ConceptosnegocioService,
  ) {}

  ngOnInit() {
    this.conceptoNegocioservice.getTop7Conceptos().subscribe(data => {
      this.conceptos = data;
    });
  }
}
