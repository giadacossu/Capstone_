import { Component, OnInit } from '@angular/core';
import { google } from 'ngx-bootstrap-icons';
import { DataService } from 'src/app/service/data.service';
@Component({
  selector: 'app-olbia',
  templateUrl: './olbia.component.html',
  styleUrls: ['./olbia.component.scss']
})
export class OlbiaComponent implements OnInit{
Data$:any;
point:any;
piatti:any;
spiagge:any
url!:string
onOver!:boolean
item!:boolean
  constructor(private DataService:DataService){  }

ngOnInit(): void {
  this.url="olbia"
  this.Data$ = this.DataService.getData()
  this.getPoint(this.url)
  this.getPiatti()
  this. getSpiagge()
  this.onOver=false
}

    onCardMouseEnter() {
      this.onOver = true;


    }
    onCardMouseLeave() {
      this.onOver = false;
    }
getPoint(url:string){
this.point = this.DataService.getDatiPoint(url)
this.point.subscribe((data: { content: any; }) => {
  this.point = data.content;

})
}
getPiatti(){
  this.piatti=this.DataService.getDatiPiattiGalluresi()
  this.piatti.subscribe((data: { content: any; }) => {
    this.piatti = data.content;

  })
  }
  getSpiagge(){
    this.spiagge=this.DataService.getSpiagge(this.url)
    this.spiagge.subscribe((data: { content: any; }) => {
      this.spiagge = data.content;

    })
    }

}
