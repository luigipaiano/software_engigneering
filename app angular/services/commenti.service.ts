import { Injectable } from '@angular/core';
import { Commenti } from '../models/Commenti';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CommentiService {

  commenti: Commenti[];
  url: string = 'https...' ;//url del servizio rest , io avrò localhost/getAll...
  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type':  'application/json',
    })
  };

  constructor(private http: HttpClient) { } //HttpClient  è quello giusto HAI Un PROBLEMA nell'app.module.ts

  getCommenti(): Observable<Commenti[]> {
    return this.http.get<Commenti[]>(this.url);
  }

  postCommenti(commento: Commenti): Observable<Commenti> {
    return this.http.post<Commenti>(this.url, commento , this.httpOptions ) //prende l'URL, il body e le opzioni. Se non conosco le opzioni, cerco su google la libreria angular command http



  }

}
