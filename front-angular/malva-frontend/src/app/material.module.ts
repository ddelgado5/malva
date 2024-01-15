import { NgModule } from "@angular/core";
import { CommonModule } from "@angular/common";

import { MatCardModule } from "@angular/material/card";
import { MatFormFieldModule } from "@angular/material/form-field";
import { MatInputModule } from "@angular/material/input";
import { MatButtonModule } from "@angular/material/button";
import { MatIconModule } from "@angular/material/icon";
import { MatSelectModule } from "@angular/material/select";
import { MatToolbarModule } from "@angular/material/toolbar";
import { MatSidenavModule } from "@angular/material/sidenav";
import { MatMenuModule } from "@angular/material/menu";
import { MatDialogModule } from "@angular/material/dialog";
import { MatProgressSpinnerModule } from "@angular/material/progress-spinner";
import { MatTabsModule } from "@angular/material/tabs";
import { MatTableModule } from "@angular/material/table";
import { MatPaginatorModule } from "@angular/material/paginator";
import { MatExpansionModule } from "@angular/material/expansion";
import { MatSortModule } from "@angular/material/sort";
import { MatDatepickerModule } from "@angular/material/datepicker";
import { MatNativeDateModule } from "@angular/material/core";
import { MatTooltipModule } from "@angular/material/tooltip";
import { MatSlideToggleModule } from "@angular/material/slide-toggle";
import { MatGridListModule } from "@angular/material/grid-list";
import { MatCheckboxModule } from "@angular/material/checkbox";
import { MatChipsModule } from "@angular/material/chips";
import { MatRadioModule } from "@angular/material/radio";

const myModule = [
  MatCardModule,
  MatChipsModule,
  MatFormFieldModule,
  MatInputModule,
  MatButtonModule,
  MatIconModule,
  MatSelectModule,
  MatToolbarModule,
  MatSidenavModule,
  MatMenuModule,
  MatDialogModule,
  MatProgressSpinnerModule,
  MatTabsModule,
  MatTableModule,
  MatSortModule,
  MatPaginatorModule,
  MatExpansionModule,
  MatTooltipModule,
  MatSlideToggleModule,
  MatGridListModule,
  MatCheckboxModule,
  MatNativeDateModule,
  MatChipsModule,
  MatRadioModule,
];

@NgModule({
  declarations: [],
  imports: [CommonModule, myModule],
  exports: [myModule],
  providers: [MatDatepickerModule],
})
export class MaterialModule {}
