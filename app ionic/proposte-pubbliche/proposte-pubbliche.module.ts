import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Routes, RouterModule } from '@angular/router';

import { IonicModule } from '@ionic/angular';

import { PropostePubblichePage } from './proposte-pubbliche.page';

const routes: Routes = [
  {
    path: '',
    component: PropostePubblichePage
  }
];

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    RouterModule.forChild(routes)
  ],
  declarations: [PropostePubblichePage]
})
export class PropostePubblichePageModule {}
