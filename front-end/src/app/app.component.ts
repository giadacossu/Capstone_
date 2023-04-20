import { Component, OnInit } from '@angular/core';
import { AuthService } from './auth/auth.service';
import { Token } from '@angular/compiler';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit {

  title = 'frontCapstone';

constructor(private aS :AuthService){}


 ngOnInit(): void {
this.aS.verificaCredenziali()

  }

}
