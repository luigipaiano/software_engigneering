import { Component, OnInit, ViewChild } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Proponente } from 'src/app/models/proponente';
import { Proposta } from 'src/app/models/proposta';
import { MyairbbService } from 'src/app/services/myairbb.service';
import { Beneservizio } from 'src/app/models/beneservizio';
import { THROW_IF_NOT_FOUND } from '@angular/core/src/di/injector';
import { Immagine } from 'src/app/models/immagine';

@Component({
  selector: 'app-inserisci-proposta',
  templateUrl: './inserisci-proposta.component.html',
  styleUrls: ['./inserisci-proposta.component.scss']
})
export class InserisciPropostaComponent implements OnInit {

  @ViewChild('Userform') userForm;

  proposta: Proposta[];
  id:number;
  propostacr: Proposta;
  immaginecr: Immagine;
  immagine: Immagine[];

  propostanew: Proposta;

  newProponente: Proponente;
  proponente: Proponente[];

  id2:number;
  name:string
  idbene:number;
  iter:number;

  beneservizio: Beneservizio[];
  beneserviziocr: Beneservizio;

  true:number;
  nome:string;
  path: string;
  idproposta:number;
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
  
    this.lat2="";
    this.long2="";
    this.propostacr = {} as Proposta;
    this.immaginecr = {} as Immagine;
    this.immagine = [];


   
    this.route.params.subscribe(params => {
      this.id=Number.parseInt(params['id']);

    });


    this.newProponente= {} as Proponente;
    this.beneservizio = [];
    this.beneserviziocr = {} as Beneservizio;

    this.service.getProponenteByIdProponente(this.id).subscribe(data =>{
      this.newProponente=data;
      this.propostacr.proponente=data;
      this.propostacr.proponente.utente.ultimologin = new Date();




      this.service.getAllABeneservizio().subscribe( data2 => {
        this.beneservizio=data2;
      });

      for(this.iter=0; this.iter < this.beneservizio.length; this.iter++){
        if(this.beneservizio[this.iter].idbeneservizio == this.idbene){
          this.propostacr.beneservizio= this.beneservizio[this.iter];
        }
  
    }

  });

}

inserisci(){

  this.latlang1=(this.lat1 + ';'+ this.long1+ '-'+ this.lat2 + ';'+ this.long2)

  console.log(this.latlang1)



  for(this.iter=0; this.iter < this.beneservizio.length; this.iter++){
      if(this.beneservizio[this.iter].idbeneservizio == this.idbene){
        this.propostacr.beneservizio= this.beneservizio[this.iter];
      }

  }

  if(this.propostacr.datainiziodisp > this.propostacr.datafinedisp ){
    alert("Data checkin superiore a data checkout")
    return;

  }
      this.propostacr.posizione=this.latlang1;
      this.service.postProposta(this.propostacr).subscribe( data3=>{
      this.idproposta=data3.idproposta;
      this.propostanew=data3;
     })

     alert("Proposta aggiunta con successo, procedi con l'inserimento di immagini !");

     }

     addImage(){
      
      this.immaginecr.percorso=this.path.valueOf();
      this.immaginecr.proposta=this.propostanew;
      console.log(this.immaginecr.percorso)
      console.log(this.immaginecr.proposta.idproposta)

      this.service.postImmagine(this.immaginecr).subscribe( data=>{
      alert("Immagine inserita");

      this.service.getImmagineByIdProposta(this.idproposta).subscribe( data => {
        this.immagine=data;
           })

      });


    }

}