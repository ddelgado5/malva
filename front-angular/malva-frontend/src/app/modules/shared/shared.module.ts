import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HeaderComponent } from './components/header/header.component';
import { FooterComponent } from './components/footer/footer.component';
import { MaterialModule } from 'src/app/material.module';
import { ToolbarMenuComponent } from './components/toolbar-menu/toolbar-menu.component';
import { HambMenuComponent } from './components/hamb-menu/hamb-menu.component';
import { NavFooterComponent } from './components/nav-footer/nav-footer.component';
import { PrivacyPoliticsComponent } from './components/privacy-politics/privacy-politics.component';



@NgModule({
  declarations: [HeaderComponent, FooterComponent, ToolbarMenuComponent, HambMenuComponent, NavFooterComponent, PrivacyPoliticsComponent],
  imports: [
    CommonModule,
    MaterialModule,
  ],
  exports: [HeaderComponent, FooterComponent]
})
export class SharedModule { }
