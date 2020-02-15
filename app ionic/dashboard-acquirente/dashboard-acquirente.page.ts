import { Component, OnInit } from '@angular/core';
import { MyairbbService } from '../services/myairbb.service';
import { Router, ActivatedRoute } from '@angular/router';
import { Acquirente } from '../models/acquirente';
import { Notifica } from '../models/notifica';
import { Prenotazione } from '../models/prenotazione';

@Component({
  selector: 'app-dashboard-acquirente',
  templateUrl: './dashboard-acquirente.page.html',
  styleUrls: ['./dashboard-acquirente.page.scss'],
  providers: [ MyairbbService]

})
export class DashboardAcquirentePage implements OnInit {

  id_acquirente: number;
  newAcquirente: Acquirente;
  acquirente: Acquirente[];
  notifica: Notifica[];
  notifica2: Notifica[];
  prenotazioni: Prenotazione[];



  constructor(private route: ActivatedRoute,
    private router: Router,
    private myairbbservice:MyairbbService) { }

   ngOnInit() {

    this.notifica = [];
    this.notifica2 = [];
    this.prenotazioni= [];


    this.route.params.subscribe(params => {
      this.id_acquirente=Number.parseInt(params['acquirente_id']);

    });
    this.newAcquirente= {} as Acquirente;


    this.myairbbservice.getAcquirenteByIdAcquirente(this.id_acquirente).subscribe(data => {

      this.newAcquirente=data;
      console.log(this.newAcquirente.idacquirente)
    })

    this.myairbbservice.getAllNotifiche().subscribe( data => {
      this.notifica=data;
      })

    this.myairbbservice.getAllNotifiche().subscribe( data => {
      this.notifica2=data;
      })

   this.myairbbservice.getPrenotazionebyIdAcquirente(this.id_acquirente).subscribe(data => {

      this.prenotazioni= data;

    })

}


  delete(idnotifica: number){
  this.myairbbservice.deleteNotifica(idnotifica).subscribe(data=>{
    console.log(idnotifica)
    alert("Notifica eliminata !");

  })

  }

}
