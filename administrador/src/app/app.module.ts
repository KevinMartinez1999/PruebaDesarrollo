import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';

import { Routes, RouterModule } from '@angular/router';

import { FormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { ClientesComponent } from './componentes/clientes/clientes.component';
import { FormclientesComponent } from './componentes/formclientes/formclientes.component';
import { AgregarClienteComponent } from './componentes/agregar-cliente/agregar-cliente.component';
import { ClienteFrecuenteComponent } from './componentes/cliente-frecuente/cliente-frecuente.component';
import { TituloFrecuenteComponent } from './componentes/titulo-frecuente/titulo-frecuente.component';
import { FormtitulosComponent } from './componentes/formtitulos/formtitulos.component';
import { AlquilerComponent } from './componentes/alquiler/alquiler.component';
import { VentasDiaComponent } from './componentes/ventas-dia/ventas-dia.component';
import { BuscarPorDirectorComponent } from './componentes/buscar-por-director/buscar-por-director.component';
import { BuscarPorProtaComponent } from './componentes/buscar-por-prota/buscar-por-prota.component';
import { BuscarPorProductorComponent } from './componentes/buscar-por-productor/buscar-por-productor.component';

const routes:Routes = [
  {path:'', redirectTo:'/', pathMatch:'full'},
  {path:'', component:ClientesComponent},
  {path:'cliente', component:FormclientesComponent},
  {path:'agregar', component:AgregarClienteComponent},
  {path:'titulo', component:FormtitulosComponent},
  {path:'cliente/frecuente', component:ClienteFrecuenteComponent},
  {path:'titulo/frecuente', component:TituloFrecuenteComponent},
  {path:'ventas/alquilar', component:AlquilerComponent},
  {path:'ventas', component:VentasDiaComponent},
  {path:'director', component:BuscarPorDirectorComponent},
  {path:'protagonista', component:BuscarPorProtaComponent},
  {path:'productor', component:BuscarPorProductorComponent}
  ]

@NgModule({
  declarations: [
    AppComponent,
    ClientesComponent,
    FormclientesComponent,
    AgregarClienteComponent,
    ClienteFrecuenteComponent,
    TituloFrecuenteComponent,
    FormtitulosComponent,
    AlquilerComponent,
    VentasDiaComponent,
    BuscarPorDirectorComponent,
    BuscarPorProtaComponent,
    BuscarPorProductorComponent,
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    RouterModule.forRoot(routes)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
