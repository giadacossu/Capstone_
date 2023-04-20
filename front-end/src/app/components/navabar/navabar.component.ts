import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { AuthService } from 'src/app/auth/auth.service';

@Component({
  selector: 'app-navabar',
  templateUrl: './navabar.component.html',
  styleUrls: ['./navabar.component.scss']
})
export class NavabarComponent implements OnInit  {
  logged=false


  constructor(private  as: AuthService, private r:Router){}


  ngOnInit(): void {
    this.as.logged.subscribe((res)=>{
      this.logged = res
    })
  }
click(){
  if(this.logged){
    this.r.navigate(["/profilo"])
  }else{
    this.r.navigate(["/auth/login"])
  }
}
}
