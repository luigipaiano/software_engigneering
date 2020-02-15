import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CommonModule } from '@angular/common';
import { UsermybbComponent } from './components/usermybb/usermybb.component';
import { CommentiComponent } from './components/commenti/commenti.component';
import { UsersComponent } from './components/users/users.component';
import { NotfoundComponent } from './components/notfound/notfound.component';
import { UsermybbdetailComponent } from './components/usermybbdetail/usermybbdetail.component';
import { LoginComponent } from './components/login/login.component';
import { ManagebyutenteproponenteComponent } from './components/managebyutenteproponente/managebyutenteproponente.component';
import { AdminHomeComponent } from './components/admin/admin-home/admin-home.component';
import { AdminManageComponent } from './components/admin/admin-manage/admin-manage.component';
import { AdminApproveComponent } from './components/admin/admin-approve/admin-approve.component';
import { UtenteProponenteDashboardComponent } from './components/utente-proponente/utente-proponente-dashboard/utente-proponente-dashboard.component';
import { InserisciPropostaComponent } from './components/utente-proponente/inserisci-proposta/inserisci-proposta.component';
import { GestionePropostaComponent } from './components/utente-proponente/gestione-proposta/gestione-proposta.component';
import { ModificaPropostaComponent } from './components/utente-proponente/modifica-proposta/modifica-proposta.component';
import { RegistrazioneComponent } from './components/utente-proponente/registrazione/registrazione.component';
import { GestioneCommentiComponent } from './components/utente-proponente/gestione-commenti/gestione-commenti.component';
import { VisualizzaPrenotazioniComponent } from './components/utente-proponente/visualizza-prenotazioni/visualizza-prenotazioni.component';


const routes: Routes = [ //qui definiamo i nostri percorsi come chiave path e component

  {path: '', component: LoginComponent},
  {path: 'admin-home/:id', component: AdminHomeComponent},
  {path: 'admin-manage/:id', component: AdminManageComponent},
  {path: 'admin-approve/:id', component: AdminApproveComponent},
  {path: 'utente-proponente-dashboard/:id', component: UtenteProponenteDashboardComponent},
  {path: 'managebyutenteproponente/:id', component: ManagebyutenteproponenteComponent},
  {path: 'inserisci-proposta/:id', component: InserisciPropostaComponent},
  {path: 'gestione-proposta/:id', component: GestionePropostaComponent},
  {path: 'modifica-proposta/:idproponente/:idproposta', component: ModificaPropostaComponent},
  {path: 'registrazione', component: RegistrazioneComponent},
  {path: 'gestione-commenti/:idproponente/:idproposta', component: GestioneCommentiComponent},
  {path: 'visualizza-prenotazioni/:id', component: VisualizzaPrenotazioniComponent},


  //{path: 'first', component: UsermybbComponent}, //'' percorso di default. Sarà il primo ad essere visualizzato 
  //{path: 'first', component: UsermybbComponent}, //'' percorso di default. Sarà il primo ad essere visualizzato 
  //{path: 'commenti', component:CommentiComponent},
  //{path: 'users', component:UsersComponent},
  //{path: 'users/:id', component:UsermybbdetailComponent}, //devo passare anche il paramentro id al percorso
  {path: '**', component:NotfoundComponent} // per path non corretti, creiamo anche un component notfound per gestire la pagina di errore

];

@NgModule({
  imports: [
      CommonModule, 
      RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
