import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {PrincipalComponent} from "./gestionpedidos/principal/principal.component";
import {AgregarpedidoComponent} from "./gestionpedidos/agregarpedido/agregarpedido.component";
import {AgregarmigracionComponent} from "./gestionpedidos/agregarmigracion/agregarmigracion.component";
import {VerpedidosComponent} from "./gestionpedidos/verpedidos/verpedidos.component";
import {VermigracionesComponent} from "./gestionpedidos/vermigraciones/vermigraciones.component";

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
    path: '',
    redirectTo: '/principal',
    pathMatch: 'full'
  },


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
