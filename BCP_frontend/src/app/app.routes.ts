import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {PrincipalmainComponent} from './principal/principalmain/principalmain.component'
import {VerpedidosmainComponent} from './principal/verpedidosmain/verpedidosmain.component'
import {VermigracionesmainComponent} from './principal/vermigracionesmain/vermigracionesmain.component'
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
import {AgregarmodeloDdvComponent} from "./equivalenciasymodelo/agregarmodelo-ddv/agregarmodelo-ddv.component";
import { LoginComponent } from './login/login.component';
import { AuthGuard } from './guards/auth.guard';
import { ListaUsuariosComponent } from './gestionusuarios/listausuarios/listausuarios.component';
import { SeleccionarParticipantesComponent } from "./gestionreuniones/seleccionarparticipantes/seleccionarparticipantes.component";
import { AgregarUsuarioComponent } from './gestionusuarios/agregarusuario/agregarusuario.component';
import {VerreunionpendienteComponent} from "./gestionreuniones/verreunionpendiente/verreunionpendiente.component";
import {VerreunioncompletadaComponent} from "./gestionreuniones/verreunioncompletada/verreunioncompletada.component";
import {VerreporteconformidadComponent} from "./gestionreuniones/verreporteconformidad/verreporteconformidad.component";
import { DatosadicionalesComponent} from "./validacionyreportes/datosadicionales/datosadicionales.component";
import {DesignarcampoComponent} from "./validacionyreportes/designarcampo/designarcampo.component";
import {RegistrodeerroresComponent} from "./validacionyreportes/registrodeerrores/registrodeerrores.component";
import {VererroresComponent} from "./validacionyreportes/vererrores/vererrores.component";
import {ModificarusuarioComponent} from "./gestionusuarios/modificarusuario/modificarusuario.component";
import {AgregarconceptonegocioComponent} from "./equivalenciasymodelo/agregarconceptonegocio/agregarconceptonegocio.component";
import {AsociartablasComponent} from "./equivalenciasymodelo/asociartablas/asociartablas.component";
import {AgregaracuerdosComponent} from "./gestionreuniones/agregaracuerdos/agregaracuerdos.component";
import {ListareportesconformidadComponent} from "./gestionreuniones/listareportesconformidad/listareportesconformidad.component";
import{CancelarrreunionComponent} from "./gestionreuniones/cancelarrreunion/cancelarrreunion.component";
import {VerreporteconformidadgeneradoComponent} from "./gestionreuniones/verreporteconformidadgenerado/verreporteconformidadgenerado.component";
import {BuscarreporteComponent} from "./gestionreuniones/buscarreporte/buscarreporte.component";
import {VertodoConceptosComponent} from "./equivalenciasymodelo/vertodo-conceptos/vertodo-conceptos.component";
import {CrearuniversoComponent} from "./cargayprecarga/crearuniverso/crearuniverso.component";
import {PrecargaComponent} from "./cargayprecarga/precarga/precarga.component";
import {RegladecargafuncionalComponent} from "./cargayprecarga/regladecargafuncional/regladecargafuncional.component";
import {RegladecargatecnicaComponent} from "./cargayprecarga/regladecargatecnica/regladecargatecnica.component";
import {RetroalimentacionComponent} from "./cargayprecarga/retroalimentacion/retroalimentacion.component";
import {VerdeftecnicasComponent} from "./cargayprecarga/verdeftecnicas/verdeftecnicas.component";
import {VermodelosddvComponent} from "./cargayprecarga/vermodelosddv/vermodelosddv.component";
import {VeruniversoComponent} from "./cargayprecarga/veruniverso/veruniverso.component";
import {VerreglafuncionalComponent} from "./cargayprecarga/verreglafuncional/verreglafuncional.component";
import {VerreglatecnicaComponent} from "./cargayprecarga/verreglatecnica/verreglatecnica.component";
import {RendimientoUsuariosComponent} from "./gestionusuarios/rendimiento-usuarios/rendimiento-usuarios.component";

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
    path: 'gestion/rendimiento-usuarios',
    component: RendimientoUsuariosComponent,
    canActivate: [AuthGuard]
  },

  { path: 'crearuniverso',
    component: CrearuniversoComponent,
    canActivate: [AuthGuard]
  },

  { path: 'precarga',
    component: PrecargaComponent,
    canActivate: [AuthGuard]
  },

  { path: 'rcf',
    component: RegladecargafuncionalComponent,
    canActivate: [AuthGuard]
  },

  { path: 'rct',
    component: RegladecargatecnicaComponent,
    canActivate: [AuthGuard]
  },

  { path: 'corregirregla',
    component: RetroalimentacionComponent,
    canActivate: [AuthGuard]
  },
  { path: 'verdtec/:pedidoId',
    component: VerdeftecnicasComponent,
    canActivate: [AuthGuard]
  },
  { path: 'verddvs/:pedidoId',
    component: VermodelosddvComponent,
    canActivate: [AuthGuard]
  },
  { path: 'veruniverso/:pedidoId',
    component: VeruniversoComponent,
    canActivate: [AuthGuard]
  },
  { path: 'verreglafunc/:migracionId',
    component: VerreglafuncionalComponent,
    canActivate: [AuthGuard]
  },
  { path: 'verreglatec/:migracionId',
    component: VerreglatecnicaComponent,
    canActivate: [AuthGuard]
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
    path: 'gestion/modificar-usuario',
    component: ModificarusuarioComponent,
    canActivate: [AuthGuard]
  },

  {
    path: 'main',
    component: PrincipalmainComponent,
    canActivate: [AuthGuard]
  },
  {
    path: 'main/ver-pedidos',
    component: VerpedidosmainComponent,
    canActivate: [AuthGuard]
  },
  {
    path: 'main/ver-migraciones/:pedidoId',
    component: VermigracionesmainComponent,
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
    path: 'agregar-modelo',
    component: AgregarmodeloDdvComponent,
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
    path: 'reunion-pendiente/:id',
    component: VerreunionpendienteComponent,
    canActivate: [AuthGuard]
  },
  {
    path: 'reunion-completada/:id',
    component: VerreunioncompletadaComponent,
    canActivate: [AuthGuard]
  },
  { path: 'reporte-conformidad/:id',
    component: VerreporteconformidadComponent,
    canActivate: [AuthGuard]
  },
  { path: 'agregar-acuerdos/:id',
    component: AgregaracuerdosComponent ,
    canActivate: [AuthGuard]
  },
  {
    path: 'datosadicionales',
    component: DatosadicionalesComponent,
    canActivate: [AuthGuard]
  },
  {
    path: 'designarcampo',
    component: DesignarcampoComponent,
    canActivate: [AuthGuard]
  },
  {
    path: 'registrodeerrores',
    component: RegistrodeerroresComponent,
    canActivate: [AuthGuard]
  },
  {
    path: 'vererrores',
    component: VererroresComponent,
    canActivate: [AuthGuard]
  },

  { path: 'agregar-cn',
    component: AgregarconceptonegocioComponent,
    canActivate: [AuthGuard]
  },

  { path: 'asociar-tablas',
    component: AsociartablasComponent,
    canActivate: [AuthGuard]
  },

  { path: 'ver-todoConceptos',
    component: VertodoConceptosComponent,
    canActivate: [AuthGuard]
  },

  { path: 'lista-reportes-conformidad',
    component: ListareportesconformidadComponent,
    canActivate: [AuthGuard]
  },
  { path: 'buscar-reporte-conformidad',
    component: BuscarreporteComponent,
    canActivate: [AuthGuard]
  },
  { path: 'cancelar-reunion-pendiente/:id',
    component: CancelarrreunionComponent,
    canActivate: [AuthGuard]
  },
  {
    path: 'reporte-conformidad-generado/:id',
    component: VerreporteconformidadgeneradoComponent,
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
