import { Component, OnInit, ViewChild } from '@angular/core';
import { Proposta } from 'src/app/models/proposta';
import { Proponente } from 'src/app/models/proponente';
import { Beneservizio } from 'src/app/models/beneservizio';
import { Immagine } from 'src/app/models/immagine';
import { ActivatedRoute, Router } from '@angular/router';
import { MyairbbService } from 'src/app/services/myairbb.service';
import { Commento } from 'src/app/models/commento';


@Component({
  selector: 'app-gestione-commenti',
  templateUrl: './gestione-commenti.component.html',
  styleUrls: ['./gestione-commenti.component.scss']
})
export class GestioneCommentiComponent implements OnInit {

  @ViewChild('Userform') userForm;

  proposta: Proposta[];
  idproponente:number;
  idproposta:number;
  propostacr: Proposta;
  propostanew: Proposta;
  commento: Commento[];
  commentocr: Commento;
  descrizione: string;
  replydesc: string;

  
  newProponente: Proponente;
  proponente: Proponente[];
  
  id2:number;
  name:string
  idbene:number;
  iter:number;
  old:Beneservizio;


  beneservizio: Beneservizio[];
  beneserviziocr: Beneservizio;


  immagine: Immagine[];
  immaginecr: Immagine;


  true:number;
  nome:string;
  path: string;
  idproposta2:number;
  idimmagine:number;
  saveidcommento:number;

  constructor(private route: ActivatedRoute,
    private service: MyairbbService,
    private router: Router) { 
}
ngOnInit() {
  
  this.commentocr = {} as Commento;
  this.propostacr = {} as Proposta;
  this.commento = [];


  this.route.params.subscribe(params => {
    this.idproponente=Number.parseInt(params['idproponente'],);
    this.idproposta=Number.parseInt(params['idproposta'],);
  });

  
  this.newProponente= {} as Proponente;
  this.beneservizio = [];
  this.immagine = [];
  this.beneserviziocr = {} as Beneservizio;
  this.immaginecr = {} as Immagine;

  this.service.getProponenteByIdProponente(this.idproponente).subscribe(data =>{
    this.newProponente=data;

  })

  this.service.getPropostaByIdProposta(this.idproposta).subscribe(data =>{
    
    this.propostacr=data;
  
    this.service.getImmagineByIdProposta(this.idproposta).subscribe( data => {
    this.immagine=data;
      console.log(this.immagine);
        });
  
    this.service.getAllCommento().subscribe( data => {
      this.commento=data;

    });

    console.log(this.propostacr)

    });

}


rispondi(idcommento:number, ) {

  this.service.getCommentoByIdCommmento(idcommento).subscribe( data => {

    this.saveidcommento=idcommento;
    
    this.replydesc=('In risposta al commento n. '+ +data.idcommento+ ' "' +data.descrizione+ '" di ' +data.acquirente.utente.nome+ ' '+data.acquirente.utente.cognome )
    console.log(this.replydesc)

  })
  
}

invia(){

  console.log(this.saveidcommento)

  this.commentocr.proposta=this.propostacr;

  this.commentocr.data= new Date();
  this.commentocr.tipo=0;
  this.commentocr.val=0;
  this.descrizione=(this.replydesc+ ' : '+ this.commentocr.descrizione);
  this.commentocr.descrizione= this.descrizione;

  //this.service.getCommentoByIdCommmento(this.saveidcommento).subscribe( data=>{

  
  //this.commentocr.acquirente=data.acquirente;

  //console.log("hereee")

  //console.log(this.commentocr.acquirente)


  //})

  console.log("questo è il json pronto ad essere scritto nel db")

  console.log(this.commentocr)

   
  this.service.postCommento(this.commentocr).subscribe( data=>{

    console.log(this.commentocr)
    alert("Commento di risposta inviato con successo !");
    
    //console.log(idbeneservizio)
  
      
      })
  
    window.location.reload();

   
}

}