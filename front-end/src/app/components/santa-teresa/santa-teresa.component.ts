import { Component, OnInit } from '@angular/core';
import { DataService } from 'src/app/service/data.service';

@Component({
  selector: 'app-santa-teresa',
  templateUrl: './santa-teresa.component.html',
  styleUrls: ['./santa-teresa.component.scss']
})
export class SantaTeresaComponent  implements OnInit{
point:any
piatti:any
Data$:any
spiagge:any
url!:string
onOver!:boolean
  constructor(private DataService:DataService){}

  ngOnInit(): void {
    this.url= "Santa Teresa"
    this.Data$ = this.DataService.getData()
    this.getPoint(this.url)
    this. getPiatti()
    this.getSpiagge()
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
      onCardMouseEnter() {
        this.onOver = true;


      }
      onCardMouseLeave() {
        this.onOver = false;
      }
}
