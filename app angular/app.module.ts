import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { UsersComponent } from './components/users/users.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import { FormsModule } from '@angular/forms';
import { DataService } from './services/data.service';
import { CommentiService } from './services/commenti.service';
import { CommentiComponent } from './components/commenti/commenti.component';
import { HttpClientModule } from '@angular/common/http';
import { MyairbbService } from './services/myairbb.service';
import { UsermybbComponent } from './components/usermybb/usermybb.component';
import { NotfoundComponent } from './components/notfound/notfound.component';
import { UsermybbdetailComponent } from './components/usermybbdetail/usermybbdetail.component';
import { LoginComponent } from './components/login/login.component';
import { NavbarAdminComponent } from './components/navbar-admin/navbar-admin.component';
import { NavbarUserproponenteComponent } from './components/navbar-userproponente/navbar-userproponente.component';
import { ManagebyutenteproponenteComponent } from './components/managebyutenteproponente/managebyutenteproponente.component';
import { AdminManageComponent } from './components/admin/admin-manage/admin-manage.component';
import { AdminHomeComponent } from './components/admin/admin-home/admin-home.component';
import { AdminApproveComponent } from './components/admin/admin-approve/admin-approve.component';
import { UtenteProponenteDashboardComponent } from './components/utente-proponente/utente-proponente-dashboard/utente-proponente-dashboard.component';
import { InserisciPropostaComponent } from './components/utente-proponente/inserisci-proposta/inserisci-proposta.component';
import { GestionePropostaComponent } from './components/utente-proponente/gestione-proposta/gestione-proposta.component';
import { ModificaPropostaComponent } from './components/utente-proponente/modifica-proposta/modifica-proposta.component';
import { RegistrazioneComponent } from './components/utente-proponente/registrazione/registrazione.component';
import { GestioneCommentiComponent } from './components/utente-proponente/gestione-commenti/gestione-commenti.component';
import { VisualizzaPrenotazioniComponent } from './components/utente-proponente/visualizza-prenotazioni/visualizza-prenotazioni.component';


@NgModule({
  declarations: [
    AppComponent,
    UsersComponent,
    NavbarComponent,
    CommentiComponent,
    UsermybbComponent,
    NotfoundComponent,
    UsermybbdetailComponent,
    LoginComponent,
    NavbarAdminComponent,
    NavbarUserproponenteComponent,
    ManagebyutenteproponenteComponent,
    AdminHomeComponent,
    AdminManageComponent,
    AdminApproveComponent,
    UtenteProponenteDashboardComponent,
    InserisciPropostaComponent,
    GestionePropostaComponent,
    ModificaPropostaComponent,
    RegistrazioneComponent,
    GestioneCommentiComponent,
    VisualizzaPrenotazioniComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule //non lo trova
  ],
  providers: [DataService, CommentiService, MyairbbService],
  bootstrap: [AppComponent]
})
export class AppModule { }
