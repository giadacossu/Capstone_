import { Component, OnInit } from '@angular/core';
import { DataService } from 'src/app/service/data.service';

@Component({
  selector: 'app-alghero',
  templateUrl: './alghero.component.html',
  styleUrls: ['./alghero.component.scss']
})
export class AlgheroComponent implements OnInit {
  Data$:any;
  piatti:any;
  point:any
  spiagge:any;
  url!:string
  onOver!:boolean

  constructor(private DataService:DataService){  }

ngOnInit(): void {
  this.url="alghero"
 this.Data$ = this.DataService.getData()
 this.getPoint(this.url)
this.getPiatti()
 this.getSpiagge()
}
getPoint(url:string){
  this.point = this.DataService.getDatiPoint(url)
  this.point.subscribe((data: { content: any; }) => {
    this.point = data.content;

  })
  }
  getPiatti(){
    this.piatti=this.DataService.getPiatti("Alghero")
    this.piatti.subscribe((data: { content: any[]; }) => {
      this.piatti = data.content;

    })
    }
    getSpiagge(){
      this.spiagge=this.DataService.getSpiagge(this.url)
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
