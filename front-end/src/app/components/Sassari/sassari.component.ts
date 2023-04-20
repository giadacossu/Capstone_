import { Component, OnInit } from '@angular/core';
import { DataService } from 'src/app/service/data.service';

@Component({
  selector: 'app-sassari',
  templateUrl: './sassari.component.html',
  styleUrls: ['./sassari.component.scss']
})
export class SassariComponent implements OnInit {
  Data$:any;
  point:any
  piatti:any
spiagge:any
url!:string
onOver!:boolean

  constructor(private DataService:DataService){  }

ngOnInit(): void {
  this.Data$ = this.DataService.getData()
    this.url= "Sassari"
this.getPoint(this.url)
this.getSpiagge();
this.  getPiatti()

}

getPoint(url:string){
  this.point = this.DataService.getDatiPoint(url)
  this.point.subscribe((data: { content: any; }) => {
    this.point = data.content;

  })
  }



  getPiatti(){
    this.piatti=this.DataService.getPiatti(this.url)
    this.piatti.subscribe((data: { content: any; }) => {
      this.piatti = data.content;

    })
    }

getSpiagge(){
  this.spiagge=this.DataService.getSpiagge("sassari")
  this.spiagge.subscribe((data: { content: any; }) => {
    this.spiagge = data.content;

  })
  }
  onCardMouseEnter() {
    this.onOver = true;

  }
  onCardMouseLeave() {
    this.onOver = false;
  }
}
