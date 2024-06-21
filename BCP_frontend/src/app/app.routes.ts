import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { PrincipalComponent } from "./gestionpedidos/principal/principal.component";
import { AgregarpedidoComponent } from "./gestionpedidos/agregarpedido/agregarpedido.component";
import { AgregarmigracionComponent } from "./gestionpedidos/agregarmigracion/agregarmigracion.component";
import { VerpedidosComponent } from "./gestionpedidos/verpedidos/verpedidos.component";
import { VermigracionesComponent } from "./gestionpedidos/vermigraciones/vermigraciones.component";
import { PrincipalReunionesComponent } from "./gestionreuniones/principal/principal.component";
import { CrearReunionComponent } from "./gestionreuniones/crearreunion/crearreunion.component";
import {VerprogresoComponent} from "./equivalenciasymodelo/verprogreso/verprogreso.component";
import {VerReporteTareasComponent} from "./equivalenciasymodelo/verreportetareas/verreportetareas.component";
import {VerconceptosnegocioComponent} from "./equivalenciasymodelo/verconceptosnegocio/verconceptosnegocio.component";
import {VerequivalenciasComponent} from "./equivalenciasymodelo/verequivalencias/verequivalencias.component";
import {VermodeloDDVComponent} from "./equivalenciasymodelo/vermodelo-ddv/vermodelo-ddv.component";

export const routes: Routes = [
  {
    path: 'principal',
    component: PrincipalComponent
  },
  {
    path: 'crear-pedido',
    component: AgregarpedidoComponent
  },
  {
    path: 'crear-migracion',
    component: AgregarmigracionComponent
  },
  {
    path: 'ver-pedidos',
    component: VerpedidosComponent
  },
  {
    path: 'ver-migraciones',
    component: VermigracionesComponent
  },
  {
    path: 'reuniones',
    component: PrincipalReunionesComponent
  },
  {
    path: 'crear-reunion', // Añade esta ruta
    component: CrearReunionComponent
  },
  {
    path: '',
    redirectTo: '/principal',
    pathMatch: 'full'
  },

  {
    path: 'ver-progreso',
    component: VerprogresoComponent
  },

  {
    path: 'ver-reporteTareas',
    component: VerReporteTareasComponent
  },

  {
    path: 'ver-conceptosNegocio',
    component: VerconceptosnegocioComponent
  },

  {
    path: 'buscar-equivalencias',
    component: VerequivalenciasComponent
  },

  {
    path: 'buscar-modelo',
    component: VermodeloDDVComponent
  },

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
