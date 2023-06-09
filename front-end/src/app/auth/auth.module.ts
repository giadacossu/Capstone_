import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { LoginComponent } from './login/login.component';
import { SignupComponent } from './signup/signup.component';
import { RouterModule, Routes } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { ProfiloComponent } from '../components/profilo/profilo.component';

const routes:Routes = [
  {
    path:'login',
    component: LoginComponent
  },
  {
    path:'singup',
    component: SignupComponent
  },
  {
    path:'profilo',
    component: ProfiloComponent
  }

]

@NgModule({
  declarations: [
    LoginComponent,
    SignupComponent
  ],
  imports: [
    CommonModule,
   RouterModule.forChild(routes),
    FormsModule
  ]
})
export class AuthModule { }
