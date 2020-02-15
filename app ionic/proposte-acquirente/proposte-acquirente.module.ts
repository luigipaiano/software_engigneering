import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Routes, RouterModule } from '@angular/router';

import { IonicModule } from '@ionic/angular';

import { ProposteAcquirentePage } from './proposte-acquirente.page';

const routes: Routes = [
  {
    path: '',
    component: ProposteAcquirentePage
  }
];

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    RouterModule.forChild(routes)
  ],
  declarations: [ProposteAcquirentePage]
})
export class ProposteAcquirentePageModule {}
