import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { PrincipalComponent } from "./gestionpedidos/principal/principal.component";
import { AgregarpedidoComponent } from "./gestionpedidos/agregarpedido/agregarpedido.component";
import { AgregarmigracionComponent } from "./gestionpedidos/agregarmigracion/agregarmigracion.component";
import { VerpedidosComponent } from "./gestionpedidos/verpedidos/verpedidos.component";
import { VermigracionesComponent } from "./gestionpedidos/vermigraciones/vermigraciones.component";
import { PrincipalReunionesComponent } from "./gestionreuniones/principal/principal.component";
import { CrearReunionComponent } from "./gestionreuniones/crearreunion/crearreunion.component";
import { VerprogresoComponent } from "./equivalenciasymodelo/verprogreso/verprogreso.component";
import { VerReporteTareasComponent } from "./equivalenciasymodelo/verreportetareas/verreportetareas.component";
import { VerconceptosnegocioComponent } from "./equivalenciasymodelo/verconceptosnegocio/verconceptosnegocio.component";
import { VerequivalenciasComponent } from "./equivalenciasymodelo/verequivalencias/verequivalencias.component";
import { VermodeloDDVComponent } from "./equivalenciasymodelo/vermodelo-ddv/vermodelo-ddv.component";
import { LoginComponent } from './login/login.component';
import { AuthGuard } from './guards/auth.guard';
import { ListaUsuariosComponent } from './gestionusuarios/listausuarios/listausuarios.component';
import { SeleccionarParticipantesComponent } from "./gestionreuniones/seleccionarparticipantes/seleccionarparticipantes.component";
import { AgregarUsuarioComponent } from './gestionusuarios/agregarusuario/agregarusuario.component';

export const routes: Routes = [
  {
    path: '',
    redirectTo: '/login',
    pathMatch: 'full'
  },
  {
    path: 'login',
    component: LoginComponent
  },
  { path: 'gestion/usuarios',
    component: ListaUsuariosComponent,
    canActivate: [AuthGuard]
  },

  {
    path: 'gestion/agregar-usuario',
    component: AgregarUsuarioComponent,
    canActivate: [AuthGuard]
  },

  {
    path: 'principal',
    component: PrincipalComponent,
    canActivate: [AuthGuard]
  },
  {
    path: 'crear-pedido',
    component: AgregarpedidoComponent,
    canActivate: [AuthGuard]
  },
  {
    path: 'crear-migracion',
    component: AgregarmigracionComponent,
    canActivate: [AuthGuard]
  },
  {
    path: 'ver-pedidos',
    component: VerpedidosComponent,
    canActivate: [AuthGuard]
  },
  {
    path: 'ver-migraciones/:pedidoId',
    component: VermigracionesComponent,
    canActivate: [AuthGuard]
  },
  {
    path: 'reuniones',
    component: PrincipalReunionesComponent,
    canActivate: [AuthGuard]
  },
  {
    path: 'crear-reunion',
    component: CrearReunionComponent,
    canActivate: [AuthGuard]
  },
  {
    path: 'ver-progreso',
    component: VerprogresoComponent,
    canActivate: [AuthGuard]
  },
  {
    path: 'ver-reporteTareas',
    component: VerReporteTareasComponent,
    canActivate: [AuthGuard]
  },
  {
    path: 'ver-conceptosNegocio',
    component: VerconceptosnegocioComponent,
    canActivate: [AuthGuard]
  },
  {
    path: 'buscar-equivalencias',
    component: VerequivalenciasComponent,
    canActivate: [AuthGuard]
  },
  {
    path: 'buscar-modelo',
    component: VermodeloDDVComponent,
    canActivate: [AuthGuard]
  },
  {
    path: 'paso1',
    component: CrearReunionComponent,
    canActivate: [AuthGuard]
  },
  {
    path: 'paso2',
    component: SeleccionarParticipantesComponent,
    canActivate: [AuthGuard]
  },
  {
    path: '**',
    redirectTo: '/login',
    pathMatch: 'full'
  },

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
