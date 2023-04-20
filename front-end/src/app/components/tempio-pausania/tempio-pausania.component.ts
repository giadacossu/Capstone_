import { Component,OnInit } from '@angular/core';
import { DataService } from '../../service/data.service';
import { AuthService } from 'src/app/auth/auth.service';



@Component({
  selector: 'app-tempio-pausania',
  templateUrl: './tempio-pausania.component.html',
  styleUrls: ['./tempio-pausania.component.scss']
})
export class TempioPausaniaComponent implements OnInit {

  logged = false;


  Data$:any
  Piatti:any;
  page:number = 1;
 pageSize:number=5;
point: any;
url!:string
onOver!:boolean
item!:boolean

constructor(private DataService: DataService,private  as: AuthService) {

  }
ngOnInit(): void {
  this.Data$ = this.DataService.getData()
this.as.logged.subscribe((res)=>{
  this.logged = res
  this.url= "tempio pausania"
})



       this.Data$ = this.DataService.getData()
       this.getPiatti();
      this.getPoint(this.url);

}

getPoint(url:string){
  this.point = this.DataService.getDatiPoint(url)
  this.point.subscribe((data: { content: any; }) => {
    this.point = data.content;

  })
  }
getPiatti(){
  this.Piatti=this.DataService.getDatiPiattiGalluresi()
  this.Piatti.subscribe((data: { content: any; }) => {
    this.Piatti = data.content;

  })
  }
  onCardMouseEnter() {
    this.onOver = true;

    this.item= true
  }
  onCardMouseLeave() {
    this.onOver = false;
  }
/*onClick(){
this.click = true
console.log('cliccato')
}*/
}
