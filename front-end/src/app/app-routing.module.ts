import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { TempioPausaniaComponent } from './components/tempio-pausania/tempio-pausania.component';
import { OlbiaComponent } from './components/olbia/olbia.component';

import { SassariComponent } from './components/Sassari/sassari.component';
import { AlgheroComponent } from './components/Alghero/alghero.component';
import { ProfiloComponent } from './components/profilo/profilo.component';
import { SantaTeresaComponent } from './components/santa-teresa/santa-teresa.component';
import { CreaCittaComponent } from './components/crea-citta/crea-citta.component';





const routes: Routes = [
{path:'',
component:HomeComponent},
{path:'Tempio Pausania',
component:TempioPausaniaComponent},
{path:'olbia',
component:OlbiaComponent},
{path:'Santa Teresa',
component:SantaTeresaComponent},
{path:'Sassari',
component:SassariComponent},
{path:'Alghero',
component:AlgheroComponent},
{path:'crea-citta',
component:CreaCittaComponent},
{path:'profilo',
component:ProfiloComponent,},//canActivate: []
{
  path: 'auth',
  loadChildren: ()=>import("./auth/auth.module").then(m=>m.AuthModule)
}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
