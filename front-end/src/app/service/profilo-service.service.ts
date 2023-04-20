import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
@Injectable({
  providedIn: 'root'
})
export class ProfiloServiceService {

  constructor(private h: HttpClient) { }


  get(url:string){
    return  this.h.get(url)
    }



delete(dato:string){
  return  this.h.delete("http://localhost:8080/citta/"+dato)

}
}
