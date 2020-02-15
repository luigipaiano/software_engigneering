import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { MyairbbService } from '../services/myairbb.service';
import { Proposta } from '../models/proposta';
import { Immagine } from '../models/immagine';
import { Acquirente } from '../models/acquirente';
import { Notifica } from '../models/notifica';
import { Proponente } from '../models/proponente';
import { Utente } from '../models/utente';

@Component({
  selector: 'app-proposte-acquirente',
  templateUrl: './proposte-acquirente.page.html',
  styleUrls: ['./proposte-acquirente.page.scss'],
})
export class ProposteAcquirentePage implements OnInit {

  proposte: Proposta[] = [];
  immagine: Immagine[];
  id_acquirente: number;
  newAcquirente: Acquirente;
  acquirente: Acquirente[];
  notifica: Notifica;
  proposta:Proposta;
  proponente_id: number;

  newProponente: Proponente;
  proponente: Proponente[];



  constructor(private route: ActivatedRoute,
    private router: Router,
    private myairbbservice:MyairbbService) { }


  ngOnInit() {

    this.notifica= {} as Notifica;
    this.proposta= {} as Proposta;
    this.newAcquirente= {} as Acquirente;
    this.newProponente= {} as Proponente;
    this.proposta.proponente= {} as Proponente;
    this.proposta.proponente.utente= {} as Utente;
    
    this.route.params.subscribe(params => {
      this.id_acquirente=Number.parseInt(params['acquirente_id']);

    });

    this.newAcquirente= {} as Acquirente;


    this.immagine = [];
    this.myairbbservice.getByApproved().subscribe(list => {
    this.proposte = list;
    

    })

    this.myairbbservice.getAllImmagine().subscribe( data => {
      console.log(this.immagine);
      this.immagine=data;

})

this.myairbbservice.getAcquirenteByIdAcquirente(this.id_acquirente).subscribe(data => {
  this.newAcquirente=data;
  console.log(this.newAcquirente.idacquirente)
})
}



gotoproposta(idproposta: number, id_acquirente: number){

this.myairbbservice.getPropostaByIdProposta(idproposta).subscribe(data => {
  this.proposta=data;
  this.proponente_id=data.proponente.idproponente;

  this.myairbbservice.getProponenteByIdProponente(this.proponente_id).subscribe(data => {
    this.newProponente=data;
})
  
})

this.myairbbservice.getAcquirenteByIdAcquirente(id_acquirente).subscribe(data=> {

  this.notifica.acquirente = data;
  this.notifica.acquirente= data;
})



this.notifica.proposta= this.proposta;
this.notifica.proponente= this.proposta.proponente;

this.notifica.tipo= 1;

this.notifica.data= new Date();

this.notifica.descrizione=" La proposta "+ this.notifica.proposta.nome+" è stata visualizzata da "+ this.notifica.acquirente.utente.nome+" "+ this.notifica.acquirente.utente.cognome+""

this.notifica.data= new Date();

this.myairbbservice.postNotifica(this.notifica).subscribe(data=> {
  console.log(data);
    })


    this.router.navigate(["/booking", idproposta, id_acquirente]);
}


}