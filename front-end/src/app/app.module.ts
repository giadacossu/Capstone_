import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { NgxBootstrapIconsModule } from 'ngx-bootstrap-icons';
import { allIcons } from 'ngx-bootstrap-icons';


import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './components/home/home.component';
import { NavabarComponent } from './components/navabar/navabar.component';
import {HttpClientModule} from '@angular/common/http';
import { TempioPausaniaComponent } from './components/tempio-pausania/tempio-pausania.component';
import { OlbiaComponent } from './components/olbia/olbia.component';

import { SassariComponent } from './components/Sassari/sassari.component';
import { AlgheroComponent } from './components/Alghero/alghero.component';
import { ProfiloComponent } from './components/profilo/profilo.component';
import { FooterComponent } from './components/footer/footer.component';
import { SantaTeresaComponent } from './components/santa-teresa/santa-teresa.component';

import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { CreaCittaComponent } from './components/crea-citta/crea-citta.component';





@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    NavabarComponent,
    TempioPausaniaComponent,
    OlbiaComponent,
    SassariComponent,
    AlgheroComponent,
    ProfiloComponent,
    FooterComponent,
    SantaTeresaComponent,
    CreaCittaComponent,







  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    FormsModule,
    HttpClientModule,
    NgxBootstrapIconsModule.pick(allIcons)
  ],
  providers: [],
  bootstrap: [AppComponent],

}
)
export class AppModule { }
