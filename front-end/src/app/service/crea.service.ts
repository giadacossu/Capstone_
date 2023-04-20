import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

export interface citta{
  nome:string,
  provincia:string,
  url:string
  utente:string

}
export interface point{
  nome:string,
  descrizione:string,
  citta:string,
  url:string
  percorso:string
  utente:string
}



export interface piatti{
  nome:string,
  descrizione:string,
  citta:string,
  url:string,
  utente:string

}


@Injectable({
  providedIn: 'root'
})




export class CreaService {

  constructor(private h:HttpClient ){}






  insert(url:string, body:{}){
  return  this.h.post(url,body)
  }

sendC(a:citta){
    return this.h.post("http://localhost:8080/citta", a)
    }

sendP(b:point){
  return this.h.post("http://localhost:8080/point", b)
  }

  sendPi(f:piatti){
return this.h.post("http://localhost:8080/piattiTipici",f)
}
sendS(e:point){
return this.h.post('http://localhost:8080/spiagge',e)

}
}
