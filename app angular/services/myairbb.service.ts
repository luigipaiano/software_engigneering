import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Utente } from '../models/utente';
import { Admin } from '../models/admin';
import { Acquirente } from '../models/acquirente';
import { Proponente } from '../models/proponente';
import { Beneservizio } from '../models/beneservizio';
import { Immagine } from '../models/immagine';
import { Pagamento } from '../models/pagamento';
import { UserMyBB } from '../models/UserMyBB';
import { BookingMyBB } from '../models/BookingMyBB';
import { Proposta } from '../models/proposta';
import { Commento } from '../models/commento';
import { Prenotazione } from '../models/prenotazione';
import { Notifica } from '../models/notifica';

@Injectable({
  providedIn: 'root'
})
export class MyairbbService {
  linkAcquirente: string = 'http://localhost:8080/acquirente/';
  linkAdmin: string = 'http://localhost:8080/admin/';
  linkBeneservizio: string = 'http://localhost:8080/beneservizio/';
  linkCommento: string = 'http://localhost:8080/commento/';
  linkImmagine: string = 'http://localhost:8080/immagine/';
  linkPagamento: string = 'http://localhost:8080/pagamento/';
  linkPrenotazione: string = 'http://localhost:8080/prenotazione/';
  linkProponente: string = 'http://localhost:8080/proponente/';
  linkProposta: string = 'http://localhost:8080/proposta/';
  linkUtente: string = 'http://localhost:8080/utente/';
  linkNotifica: string = 'http://localhost:8080/notifica/';

  linkUser: string = 'http://localhost:8080/user/';
  linkBooking: string = 'http://localhost:8080/booking/';


  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type':  'application/json',
    })
  };

  constructor(private  http: HttpClient) { }

  postUtente(utente: Utente): Observable<Utente> {
    return this.http.post<Utente>(this.linkUtente+ 'save/', utente , this.httpOptions);
  }

  getUtenteByIdUtente(user_id: number): Observable<Utente>{
    return this.http.get<Utente>(this.linkUtente+ 'getByIdUtente/'+ user_id);

  }

  getAllUtente(): Observable<Utente[]>{
    return this.http.get<Utente[]>(this.linkUtente+ 'getAll');
  }

  getUtenteByUsernameAndPassword(username: string , password: string): Observable<Utente[]>{
    return this.http.get<Utente[]>(this.linkUtente+ 'getByUsernameandPassword/' + username + '/' + password);
  }


  postAdmin(admin: Admin): Observable<Admin> {
    return this.http.post<Admin>(this.linkAdmin+ 'save/', admin , this.httpOptions);
  }

  getAdminByIdAmin(admin_id: number): Observable<Admin>{
    return this.http.get<Admin>(this.linkAdmin+ 'getByIdAdmin/'+ admin_id);

  }

  getAllAdmin(): Observable<Admin[]>{
    return this.http.get<Admin[]>(this.linkAdmin+ 'getAll');
  }

  getAdminByUsernameAndPassword(username: string , password: string): Observable<Admin[]>{
    return this.http.get<Admin[]>(this.linkAdmin+ 'getByUsernameandPassword/' + username + '/' + password);
  }


  postAcquirente(acquirente: Acquirente): Observable<Acquirente> {
    return this.http.post<Acquirente>(this.linkAcquirente+ 'save/', acquirente , this.httpOptions);
  }
  
 getAcquirenteByIdAcquirente(acquirente_id: number): Observable<Acquirente>{
    return this.http.get<Acquirente>(this.linkAcquirente+ 'getByIdAcquirente/'+ acquirente_id);

  }

  getAllAcquirente(): Observable<Acquirente[]>{
    return this.http.get<Acquirente[]>(this.linkAcquirente+ 'getAll/');
  }

  getAcquirenteByUsernameAndPassword(username: string , password: string): Observable<Acquirente[]>{
    return this.http.get<Acquirente[]>(this.linkAcquirente+ 'getByUsernameandPassword' + username + '/' + password);
  }



  postProponente(proponente: Proponente): Observable<Proponente> {
    return this.http.post<Proponente>(this.linkProponente+ 'save', proponente , this.httpOptions);
  }
  
 getProponenteByIdProponente(proponente_id: number): Observable<Proponente>{
    return this.http.get<Proponente>(this.linkProponente+ 'getByIdProponente/'+ proponente_id);

  }

  getAllAProponente(): Observable<Proponente[]>{
    return this.http.get<Proponente[]>(this.linkProponente+ 'getAll');
  }

  getProponenteByUsernameAndPassword(username: string , password: string): Observable<Proponente[]>{
    return this.http.get<Proponente[]>(this.linkProponente+ 'getByUsernameandPassword/' + username + '/' + password);
  }


  getAllABeneservizio(): Observable<Beneservizio[]>{
    return this.http.get<Beneservizio[]>(this.linkBeneservizio+ 'getAll');
  }

  getBeneservizioByCategoria(categoria: string): Observable<Beneservizio[]>{
    return this.http.get<Beneservizio[]>(this.linkBeneservizio+ 'getByCategoria/' + categoria);
  }

  postBeneservizio(beneservizio: Beneservizio): Observable<Beneservizio> {
    return this.http.post<Beneservizio>(this.linkBeneservizio+ 'save/', beneservizio , this.httpOptions);
  }
  
  updateBeneservizio(beneservizio: Beneservizio): Observable<Beneservizio> {
    return this.http.put<Beneservizio>(this.linkBeneservizio+ 'update/', beneservizio , this.httpOptions);
  }

  deleteBeneservizio(beneservizio_id: number): Observable<boolean> {
  return this.http.delete<boolean>(this.linkBeneservizio + 'delete/'+ beneservizio_id);
  }
      
  getBeneServizioById(beneservizio_id: number): Observable<Beneservizio>{
    return this.http.get<Beneservizio>(this.linkBeneservizio+ 'getByIdBeneservizio/'+ beneservizio_id);

  }

  getAllImmagine(): Observable<Immagine[]>{
    return this.http.get<Immagine[]>(this.linkImmagine+ 'getAll');
  }

  getImmagineByIdProposta(proposta_id: number): Observable<Immagine[]>{
    return this.http.get<Immagine[]>(this.linkImmagine+ 'getImmaginebyIdProposta/'+ proposta_id);

  }

  postImmagine(immagine: Immagine): Observable<Immagine> {
    return this.http.post<Immagine>(this.linkImmagine+ 'save', immagine , this.httpOptions);
  }
  
  updateImmagine(immagine: Immagine): Observable<Immagine> {
    return this.http.put<Immagine>(this.linkImmagine+ 'update/', immagine , this.httpOptions);
  }

  deleteImmagine(immagine_id: number): Observable<boolean> {
    return this.http.delete<boolean>(this.linkImmagine + 'delete/'+ immagine_id);
    }

  getImmagineById(immagine_id: number): Observable<Immagine>{
    return this.http.get<Immagine>(this.linkImmagine+ 'getByIdImmagine/'+ immagine_id);

  }

  cancellaImmagineByIdProposta(id_proposta: number): Observable<boolean> {
    return this.http.delete<boolean>(this.linkImmagine + 'cancellabyidproposta/'+ id_proposta);
    }


  postPagamento(pagamento: Pagamento): Observable<Pagamento> {
    return this.http.post<Pagamento>(this.linkPagamento+ 'save/', pagamento , this.httpOptions);
  }

  getAllPagamento(): Observable<Pagamento[]>{
    return this.http.get<Pagamento[]>(this.linkPagamento+ 'getAll');
  }

  getPagamentoById(pagamento_id: number): Observable<Pagamento>{
    return this.http.get<Pagamento>(this.linkPagamento+ 'getByIdPagamento/'+ pagamento_id);

  }

  getPagamentoByIdPrenotazione(prenotazione_id: number): Observable<Pagamento>{
    return this.http.get<Pagamento>(this.linkPagamento+ 'getByIdPrenotazione/'+ prenotazione_id);

  }

  getAllCommento(): Observable<Commento[]>{
    return this.http.get<Commento[]>(this.linkCommento+ 'getAll');
  }


  getCommentoByIdAcquirente(id_acquirente: number): Observable<Commento>{
    return this.http.get<Commento>(this.linkCommento+ 'getByIdAcquirente/'+ id_acquirente);

  }

  getCommentoByIdProposta(id_proposta: string): Observable<Commento>{
    return this.http.get<Commento>(this.linkCommento+ 'getByIdProposta/'+ id_proposta);

  }

  postCommento(commento: Commento): Observable<Commento> {
    return this.http.post<Commento>(this.linkCommento+ 'save/', commento , this.httpOptions);
  }
  
  updateCommento(commento: Commento): Observable<Commento> {
    return this.http.put<Commento>(this.linkCommento+ 'update/', commento , this.httpOptions);
  }

  deleteCommento(commento_id: number): Observable<boolean> {
    return this.http.delete<boolean>(this.linkCommento + 'delete/'+ commento_id);
    }

  getCommentoByIdCommmento(id_commento: number): Observable<Commento>{
    return this.http.get<Commento>(this.linkCommento+ 'getByIdCommento/'+ id_commento);

  }

  cancellaCommentoByIdProposta(id_proposta: number): Observable<boolean> {
    return this.http.delete<boolean>(this.linkCommento + 'cancellabyidproposta/'+ id_proposta);
    }

  getAllPrenotazione(): Observable<Prenotazione[]>{
    return this.http.get<Prenotazione[]>(this.linkPrenotazione+ 'getAll');
  }

  getPrenotazionebyIdAcquirente(id_acquirente: number): Observable<Prenotazione>{
    return this.http.get<Prenotazione>(this.linkPrenotazione+ 'getByIdAcquirente/'+ id_acquirente);

  }

  getPrenotazionebyIdProposta(id_proposta: number): Observable<Prenotazione[]>{
    return this.http.get<Prenotazione[]>(this.linkPrenotazione+ 'getByIdProposta/'+ id_proposta);

  }

  postPrenotazione(prenotazione: Prenotazione): Observable<Prenotazione> {
    return this.http.post<Prenotazione>(this.linkPrenotazione+ 'save/', prenotazione , this.httpOptions);
  }
  
  updatePrenotazione(prenotazione: Prenotazione): Observable<Prenotazione> {
    return this.http.put<Prenotazione>(this.linkPrenotazione+ 'update/', prenotazione , this.httpOptions);
  }

  deletePrenotazione(prenotazione_id: number): Observable<boolean> {
    return this.http.delete<boolean>(this.linkPrenotazione + 'delete/'+ prenotazione_id);
    }

  getPrenotazionebyIdPrenotazione(id_prenotazione: number): Observable<Prenotazione>{
    return this.http.get<Prenotazione>(this.linkPrenotazione+ 'getByIdPrenotazione/'+ id_prenotazione);

  }

  getAllProposta(): Observable<Proposta[]>{
    return this.http.get<Proposta[]>(this.linkProposta+ 'getAll');
  }

  getPropostaByIdBeneservizio(id_beneservizio: number): Observable<Proposta[]>{
    return this.http.get<Proposta[]>(this.linkProposta+ 'getByIdBeneservizio/'+ id_beneservizio);
  }

  getPropostaByIdProponente(id_proponente: number): Observable<Proposta[]>{
    return this.http.get<Proposta[]>(this.linkProposta+ 'getByIdProponente/'+ id_proponente);
  }

  postProposta(proposta: Proposta): Observable<Proposta> {
    return this.http.post<Proposta>(this.linkProposta+ 'save', proposta , this.httpOptions);
  }
  
  updateProposta(proposta: Proposta): Observable<Proposta> {
    return this.http.put<Proposta>(this.linkProposta+ 'update', proposta , this.httpOptions);
  }

  deleteProposta(proposta_id: number): Observable<boolean> {
    return this.http.delete<boolean>(this.linkProposta + 'delete/'+ proposta_id);
    }

    getPropostaByIdProposta(proposta_id: number): Observable<Proposta>{
      return this.http.get<Proposta>(this.linkProposta+ 'getByIdProposta/'+ proposta_id);
    }

    getByNonApproved(): Observable<Proposta[]> {
      return this.http.get<Proposta[]>(this.linkProposta+ 'getByNonApproved');
    }

    getByApproved(): Observable<Proposta[]> {
      return this.http.get<Proposta[]>(this.linkProposta+ 'getByApproved/');
    }


    approvaProposta(id_proposta: number): Observable<Proposta> {
      return this.http.put<Proposta>(this.linkProposta+ 'approvaproposta/' + id_proposta, this.httpOptions);
    } //check



  getAllNotifiche(): Observable<Notifica[]> {
    return this.http.get<Notifica[]>(this.linkNotifica + 'getAll');
  }


  getNotificaById(id: number): Observable<Notifica[]>{
    return this.http.get<Notifica[]>(this.linkNotifica+ 'getByIdNotifica/'+ id);
  }


  postNotifica(notifica: Notifica): Observable<Notifica> {
    return this.http.post<Notifica>(this.linkNotifica+ 'save', notifica , this.httpOptions);
  }

  deleteNotifica(notifica_id: number): Observable<boolean> {
    return this.http.delete<boolean>(this.linkNotifica + 'delete/'+ notifica_id);
    }

    
  getNotificaByIdProposta(idproposta: number): Observable<Notifica[]> {
    return this.http.get<Notifica[]>(this.linkNotifica + 'getNotificabyIdProposta/'+ idproposta);
  }


  getNotificaByIdAcquirente(idacquirente: number): Observable<Notifica[]> {
    return this.http.get<Notifica[]>(this.linkNotifica + 'getByIdAcquirente/'+ idacquirente);
  }
  
  getNotificaByIdProponente(idproponente: number): Observable<Notifica[]> {
    return this.http.get<Notifica[]>(this.linkNotifica + 'getByIdProponente/'+ idproponente);
  }
  
  getNotificaByTipo(tipo: number): Observable<Notifica[]> {
    return this.http.get<Notifica[]>(this.linkNotifica + 'getByIdProponente/'+ tipo);
  }


  
  
  getAllUsers(): Observable<UserMyBB[]> {
    return this.http.get<UserMyBB[]>(this.linkUser + 'getAll');
  }

  getUserById(user_id: string): Observable<UserMyBB> {
    return this.http.get<UserMyBB>(this.linkUser + 'getById/' + user_id);
  }

  postUser(user: UserMyBB): Observable<UserMyBB> {
    return this.http.post<UserMyBB>(this.linkUser + 'save', user, this.httpOptions);
  }

  getBookingById(booking_id: number): Observable<BookingMyBB> {
    return this.http.get<BookingMyBB>(this.linkBooking + 'get/' + booking_id);
  }


}



