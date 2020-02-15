import { NgModule } from '@angular/core';
import { PreloadAllModules, RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  { path: '', redirectTo: 'home', pathMatch: 'full' },
  { path: 'home', loadChildren: './home/home.module#HomePageModule' },
  { path: 'login', loadChildren: './login/login.module#LoginPageModule' },
  { path: 'booking/:proposal_id/:user_id', loadChildren: './booking/booking.module#BookingPageModule' },
  { path: 'prenotazioni/:acquirente_id', loadChildren: './prenotazioni/prenotazioni.module#PrenotazioniPageModule' },
  { path: 'commenti/:acquirente_id', loadChildren: './commenti/commenti.module#CommentiPageModule' },
  { path: 'registrazione', loadChildren: './registrazione/registrazione.module#RegistrazionePageModule' },
  { path: 'mappa/:lat1/:long1/:proposal_id/:acquirente_id', loadChildren: './mappa/mappa.module#MappaPageModule' },
  { path: 'proposte-pubbliche', loadChildren: './proposte-pubbliche/proposte-pubbliche.module#PropostePubblichePageModule' },
  { path: 'dashboard-acquirente/:acquirente_id', loadChildren: './dashboard-acquirente/dashboard-acquirente.module#DashboardAcquirentePageModule' },
  { path: 'proposte-acquirente/:acquirente_id', loadChildren: './proposte-acquirente/proposte-acquirente.module#ProposteAcquirentePageModule' },
];

@NgModule({
  imports: [
    RouterModule.forRoot(routes, { preloadingStrategy: PreloadAllModules })
  ],
  exports: [RouterModule]
})
export class AppRoutingModule { }
