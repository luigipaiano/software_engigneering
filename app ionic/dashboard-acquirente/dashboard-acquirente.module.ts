import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Routes, RouterModule } from '@angular/router';

import { IonicModule } from '@ionic/angular';

import { DashboardAcquirentePage } from './dashboard-acquirente.page';

const routes: Routes = [
  {
    path: '',
    component: DashboardAcquirentePage
  }
];

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    RouterModule.forChild(routes)
  ],
  declarations: [DashboardAcquirentePage]
})
export class DashboardAcquirentePageModule {}
