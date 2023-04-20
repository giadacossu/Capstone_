import { Component,  OnInit , DoCheck} from '@angular/core';
import { ProfiloServiceService } from 'src/app/service/profilo-service.service';
import { AuthService } from 'src/app/auth/auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-profilo',
  templateUrl: './profilo.component.html',
  styleUrls: ['./profilo.component.scss']
})
export class ProfiloComponent implements OnInit, DoCheck{
 user:any
  c:any
  u:any
  cCreate!:any
  point!:any
  piatti!:any
  spiagge!:any
  onOver!:boolean
constructor(private pS:ProfiloServiceService,  private aS:AuthService, private r:Router){

}
  ngDoCheck(): void {

  }


  ngOnInit(): void {

this.getUser()
this.getCreati()
this.getCreatiP()
this.getCreatiPi()
this.getCreatiS()
  }




getUser(){
  this.user=  this.pS.get("http://localhost:8080/users/email/"+this.aS.utente.email)

  this.user.subscribe((data: { content: any; }) => {

    this.user = data;


  })
}
getCreati(){
  this.c = this.pS.get("http://localhost:8080/citta/utente/"+this.aS.utente.email)
  this.c.subscribe((data: { content: any; }) => {

this.cCreate=data


  })
}
getCreatiP(){
  this.point = this.pS.get("http://localhost:8080/point/utente/"+this.aS.utente.email)
  this.point.subscribe((data: { content: any; }) => {

this.point=data


  })
}
getCreatiPi(){
  this.piatti = this.pS.get("http://localhost:8080/piattiTipici/utente/"+this.aS.utente.email)
  this.piatti.subscribe((data: { content: any; }) => {

this.piatti=data


  })
}
getCreatiS(){
  this.spiagge = this.pS.get("http://localhost:8080/spiagge/utente/"+this.aS.utente.email)
  this.spiagge.subscribe((data: { content: any; }) => {

this.spiagge=data


  })
}
delete(dato:string){

  this.pS.delete(dato)
  console.log(dato)
  }


logout(){
  this.aS.logout()

  this.r.navigate(["/auth/login"])


}

onCardMouseEnter() {
  this.onOver = true;
console.log('over')


}
onCardMouseLeave() {
  this.onOver = false;
}
}
