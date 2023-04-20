import { Component, OnInit } from '@angular/core';
import { CreaService } from '../../service/crea.service';
import { FormControl, FormGroup, NgForm, Validators } from '@angular/forms';
import { AuthService } from 'src/app/auth/auth.service';
import { rss } from 'ngx-bootstrap-icons';

@Component({
  selector: 'app-crea-citta',
  templateUrl: './crea-citta.component.html',
  styleUrls: ['./crea-citta.component.scss']
})
export class CreaCittaComponent implements OnInit{
utente!:string

constructor(private service:CreaService, private aS:AuthService ){}

  ngOnInit(): void {
 this.utente= this.aS.utente.email

  }
  SubmitC(a:NgForm){
    a.value.utente = this.utente
    this.service.sendC(a.value).subscribe((res)=>{

      window.alert("citta creata")
      a.reset()
    })
    }

SubmitP(b:NgForm){
  b.value.utente = this.utente
  this.service.sendP(b.value).subscribe((res)=>{

    window.alert("luogo creato")
    b.reset()
  })
  }


SubmitPi(f:NgForm){
  f.value.utente = this.utente
this.service.sendPi(f.value).subscribe((res)=>{

  window.alert("piatto creato")
  f.reset()
})
}
SubmitS(e:NgForm){
  e.value.utente = this.utente
  this.service.sendS (e.value).subscribe((res)=>{

    window.alert("spiaggia creata")
    e.reset()
  })
}

}

