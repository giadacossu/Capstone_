import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root',
})
export class DataService {
  private _url: string = 'http://localhost:8080/citta';

  ///tempio
  Purl: string = 'http://localhost:8080/point/citta/tempio pausania';

    u="http://localhost:8080/point/citta/"

  constructor(private http: HttpClient) {}




////////////////////////////////////////////////////
  getData() {
    return this.http.get("http://localhost:8080/citta/utente/user");
  }


  getDatiPoint( url:string) {
    return this.http.get("http://localhost:8080/point/citta/"+url);
  }

  getDatiPiattiGalluresi() {
    return this.http.get("http://localhost:8080/piattiTipici/provenienza/GALLURESE");
  }


  getSpiagge(url:string) {
    return this.http.get(  "http://localhost:8080/spiagge/citta/"+url);
  }

  getPiatti(url:string) {
    return this.http.get('http://localhost:8080/piattiTipici/citta/'+url);
  }


}
