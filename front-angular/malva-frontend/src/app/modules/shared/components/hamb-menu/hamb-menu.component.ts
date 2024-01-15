import { Component, HostBinding } from '@angular/core';

@Component({
  selector: 'app-hamb-menu',
  templateUrl: './hamb-menu.component.html',
  styleUrls: ['./hamb-menu.component.css']
})
export class HambMenuComponent {
  @HostBinding("class.navbar-opened") navbarOpened = false;

  stateMenu() {
    let x = document.getElementById("nav-menu");
    if (x?.style.display === "block") {
      x.style.display = "none";
      this.navbarOpened = false;
    } else if (x) {
      x.style.display = "block";
      this.navbarOpened = true;
    }
  }
}
