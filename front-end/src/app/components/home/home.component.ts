import { Component, OnInit } from '@angular/core';
import { take } from 'rxjs';
import { DataService } from '../../service/data.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit{
Data$:any;
 Citta:string[] = ['Tempio Pausania','olbia', 'sassari','Santa Teresa','alghero'];
dati!:[{}]


  constructor( private DataService: DataService){

}

ngOnInit(): void {
  this.getCitta()
}


getCitta(){
  this.Data$ = this.DataService.getData()
}

/*getCitta(){

  this.Data$ =  this.DataService.getData().forEach(data => {
console.log(data)
  this.dati=data
console.log(this.dati)
})
.catch(error => {

  console.error('Errore:', error);
});
}*/
}
