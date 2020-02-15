import { Component, OnInit, ViewChild } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { MyairbbService } from 'src/app/services/myairbb.service';
import { Proposta } from 'src/app/models/proposta';
import { Immagine } from 'src/app/models/immagine';
import { Proponente } from 'src/app/models/proponente';
import { Beneservizio } from 'src/app/models/beneservizio';
import { DatePipe } from '@angular/common'
import { Prenotazione } from 'src/app/models/prenotazione';
import { THIS_EXPR } from '@angular/compiler/src/output/output_ast';
import { Notifica } from 'src/app/models/notifica';


@Component({
  selector: 'app-modifica-proposta',
  templateUrl: './modifica-proposta.component.html',
  styleUrls: ['./modifica-proposta.component.scss']
})
export class ModificaPropostaComponent implements OnInit {


  @ViewChild('Userform') userForm;

  proposta: Proposta[];
  idproponente:number;
  idproposta:number;
  propostacr: Proposta;
  propostanew: Proposta;
  id_acquirente: number;
  notificacr: Notifica;


  newProponente: Proponente;
  proponente: Proponente[];
  prenotazione: Prenotazione[];

  
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
  lat1: String;
  lat2: String;
  long1: String;
  long2: String;
  latlang1: string;

  constructor(private route: ActivatedRoute,
    private service: MyairbbService,
    private router: Router) { 
}
ngOnInit() {
  
  this.propostacr = {} as Proposta;
  this.notificacr = {} as Notifica;

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
    this.old=data.beneservizio;

    console.log("quiii")
    console.log(this.propostacr.datainiziodisp)
    //this.propostacr.beneservizio.categoria= data.beneservizio.categoria;

    //console.log(data.beneservizio.categoria)
    //console.log(this.propostacr.beneservizio.categoria)
    this.propostacr.proponente.utente.ultimologin = new Date();
    console.log(this.propostacr)

    console.log(this.old)

    this.service.getAllABeneservizio().subscribe( data2 => {
      this.beneservizio=data2;
      this.beneservizio=data2;
    });    

    this.service.getImmagineByIdProposta(this.idproposta).subscribe( data => {
     this.immagine=data;
      console.log(this.immagine);
        });

    

    });

}



addImage(){
      
  this.immaginecr.percorso=this.path.valueOf();
  this.immaginecr.proposta=this.propostacr;

  this.service.postImmagine(this.immaginecr).subscribe( data=>{
  alert("Immagine inserita");
  location.reload(); 


  })
}

delete(idimmagine: number){
  console.log(idimmagine)

 this.service.deleteImmagine(idimmagine).subscribe(data=>{
  
  })

  alert("L'immagine è stata cancellata !");
  location.reload(); 

  }

update(){

  for(this.iter=0; this.iter < this.beneservizio.length; this.iter++){
    if(this.beneservizio[this.iter].idbeneservizio === this.propostacr.beneservizio.idbeneservizio){
      this.propostacr.beneservizio= this.beneservizio[this.iter];
    }
}

  if(this.propostacr.datainiziodisp > this.propostacr.datafinedisp ){
  alert("Data checkin superiore a data checkout")
  return;

}
    console.log(this.propostacr.beneservizio);

      this.service.updateProposta(this.propostacr).subscribe( data3=>{
      this.idproposta=data3.idproposta;
      this.propostanew=data3;

      console.log(this.propostanew)

    })

      this.service.getPrenotazionebyIdProposta(this.idproposta).subscribe (data => {
        this.prenotazione=data;
     })

     this.notificacr.proponente= this.newProponente;
     this.notificacr.proposta=this.propostacr;
     this.notificacr.data=new Date();
     this.notificacr.descrizione= ("La proposta "+ this.propostacr.nome+ " è stata modificata");
     this.notificacr.tipo=2;

     console.log(this.notificacr)

     this.service.postNotifica(this.notificacr).subscribe( data => {      
     })

     alert("Proposta aggiornata");


    }
     
}