import { Directive, ElementRef, HostListener } from '@angular/core';

@Directive({
  selector: '[appInfo]'
})
export class InfoDirective {

  constructor(private element: ElementRef) {


   }


   @HostListener('mouseenter')onMouseEnter(){
this.element.nativeElement.style.width = "600px"

   }
   @HostListener('mouseleave')onMouseleave(){


   }

}
