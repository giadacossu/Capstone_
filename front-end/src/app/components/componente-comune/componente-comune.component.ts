import { Component, OnInit} from '@angular/core';
import { DataService } from 'src/app/service/data.service';
@Component({
  selector: 'app-componente-comune',
  templateUrl: './componente-comune.component.html',
  styleUrls: ['./componente-comune.component.scss']
})
export class ComponenteComuneComponent {

  data$: any;
  point: any;
  piatti: any;
  spiagge: any;

  constructor(private dataService: DataService) { }

  ngOnInit(): void {
    this.data$ = this.dataService.getData('citta');
    this.getPoint();
    this.getSpiagge();
    this.getPiatti();
  }

  getPoint() {
    this.dataService.getData('point/citta/Sassari')
      .subscribe((data: { content: any; }) => {
        this.point = data.content;
        console.log(this.point[1])
      });
  }

  getPiatti() {
    this.dataService.getData('piattiTipici/citta/Sassari')
      .subscribe((data: { content: any; }) => {
        this.piatti = data.content;
        console.log(this.piatti)
      });
  }

  getSpiagge() {
    this.dataService.getData('spiagge/citta/Sassari')
      .subscribe((data: { content: any; }) => {
        this.spiagge = data.content;
        console.log(this.spiagge)
      });
  }
}
