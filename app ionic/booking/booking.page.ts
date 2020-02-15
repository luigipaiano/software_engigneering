import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { MyairbbService } from '../services/myairbb.service';
import { Proposta } from '../models/proposta';
import { Beneservizio } from '../models/beneservizio';
import { Proponente } from '../models/proponente';
import { Utente } from '../models/utente';
import { Prenotazione } from '../models/prenotazione';
import { Pagamento } from '../models/pagamento';
import { Immagine } from '../models/immagine';
import { Notifica } from '../models/notifica';
import { AlertController } from '@ionic/angular';
import { Commento } from '../models/commento';


@Component({
  selector: 'app-booking',
  templateUrl: './booking.page.html',
  styleUrls: ['./booking.page.scss'],
  
  
})
export class BookingPage implements OnInit {

  slideOpts = {
    initialSlide: 0,
    speed: 400
  };

  id_proposta:number;
  id_utente: number;
  proponente_id: number;
  proposta:Proposta;
  start:any;
  end:any;
  mindate:any;
  maxdate:any;
  days:number;
  date1:Date;
  date2:Date;
  prezzo:number;
  pagamento:string;
  prenotazione:Prenotazione;
  newPagamento: Pagamento;
  imgs: Immagine[];
  notifica: Notifica;
  notficicavisita: Notifica;
  newProposal:Proposta;
  posizione: string;
  lat1: string;
  long1: string;
  lat2: string;
  long2: string;
  commento: Commento[];
  commentocr: Commento;
  checkprenotazione:boolean;
  checkpagamento:boolean;

  newProponente: Proponente;
  proponente: Proponente[];



  constructor( private route: ActivatedRoute,
                private router: Router,
                private myairbbservice:MyairbbService,
                private alertController: AlertController) { }

  ngOnInit() {
    this.route.params.subscribe(params => {
      this.id_proposta=Number.parseInt(params['proposal_id']);
      this.id_utente=Number.parseInt(params['user_id']);

    });

    this.checkpagamento=false;
    this.checkprenotazione=false;
    this.imgs = [];
    this.newPagamento= {} as Pagamento;
    this.notifica= {} as Notifica;
    this.newPagamento.datatransazione=new Date().getTime;
    this.newProposal= {} as Proposta;

    this.commentocr = {} as Commento;
    this.commento = [];

    this.prenotazione= {} as Prenotazione;
    this.newProponente= {} as Proponente;
    this.proposta= {} as Proposta;
    this.proposta.datainiziodisp= {} as Date;
    this.proposta.datafinedisp= {} as Date;
    this.proposta.beneservizio= {} as Beneservizio;
    this.proposta.proponente= {} as Proponente;
    this.proposta.proponente.utente= {} as Utente;

    this.myairbbservice.getPropostaByIdProposta(this.id_proposta).subscribe(data=>{
      this.proposta=data;
      this.proponente_id=data.proponente.idproponente;

      this.myairbbservice.getProponenteByIdProponente(this.proponente_id).subscribe(data =>{
        this.newProponente=data;
      })

      this.mindate= new Date(data.datainiziodisp).toISOString();

      this.maxdate= new Date(data.datafinedisp).toISOString();

      console.log(this.mindate);
      this.prenotazione.proposta=data;

      this.notifica.proposta= this.proposta;
      this.notifica.proponente= this.proposta.proponente;

      this.posizione=data.posizione;
      console.log(this.posizione)

      //separa pos1 da pos2
      var splits = this.posizione.split("-", 2);

      console.log(splits)

      var splits2 = splits[0].split(";", 2);
      

      console.log(splits2)

      //var splits3 = splits[1].split(";", 2);
      //console.log(splits3)

      this.lat1= splits2[0]
      this.long1= splits2[1]

      console.log("lat1", this.lat1)
      console.log("long1", this.long1)


      //this.lat2= splits3[0]
      //this.long2= splits3[1]

     console.log("lat2", this.lat2)
      console.log("long2", this.long2)


    });


    this.myairbbservice.getImmagineByIdProposta(this.id_proposta).subscribe(data => {
      this.imgs=data;
      console.log(this.imgs)
    })
    

    this.myairbbservice.getCommentoByIdProposta(this.id_proposta).subscribe( data => {
      this.commento=data;

    });

    this.myairbbservice.getAcquirenteByIdAcquirente(this.id_utente).subscribe(data=> {

      this.prenotazione.acquirente=data;
      this.notifica.acquirente= data;

    })

  
    this.notifica.tipo= 3;

   
  }


  mappa(){


    console.log(this.lat1.replace(/ /g,''));
    console.log(this.long1.replace(/ /g,''));



    this.router.navigate(["/mappa", this.lat1.replace(/ /g,''), this.long1.replace(/ /g,''), this.id_proposta, this.id_utente]);

  }


  conta(){
    this.date1= new Date(this.start);
    this.date2= new Date(this.end);
    var diff = Math.abs(this.date1.getTime() - this.date2.getTime());
    var diffDays = Math.ceil(diff / (1000 * 3600 * 24)); 

    this.prezzo= diffDays * this.proposta.costounitario;


  }

  

  prenota(){

    this.notifica.descrizione=" La proposta "+ this.proposta.nome+" è stata acquistata da "+ this.notifica.acquirente.utente.nome+" "+ this.notifica.acquirente.utente.cognome+""

    this.newProposal= this.prenotazione.proposta;
    this.newProposal.disponibilita= this.prenotazione.proposta.disponibilita -1;
    this.prenotazione.datacheckin= new Date(this.start);
    this.prenotazione.datacheckout= new Date(this.end);
    this.prenotazione.costotot= this.prezzo;
    this.prenotazione.datatransazione= new Date();
    console.log(this.prenotazione.acquirente);
    this.myairbbservice.postPrenotazione(this.prenotazione).subscribe(data=>{

      this.newPagamento.acquirente= this.prenotazione.acquirente;
      this.newPagamento.metodo= this.pagamento;
      this.newPagamento.prenotazione=data;
      this.newPagamento.importo= this.prezzo;
      this.newPagamento.datatransazione=new Date();


        this.myairbbservice.postPagamento(this.newPagamento).subscribe(data => {
          console.log(data);
        })

      this.checkpagamento=true;

    })


    this.notifica.data= new Date();
    this.myairbbservice.postNotifica(this.notifica).subscribe(data=> {
      console.log(data);
    })

    this.myairbbservice.updateProposta(this.newProposal).subscribe(data=> {
      console.log(data)
    
    });

    this.presentAlertConfirm("prenotazione effettuata", true)

  }



  async presentAlertConfirm(messageStr: string, logged: boolean) {
    const alert = await this.alertController.create({
        header: 'Sign In',
        message: messageStr,
        buttons: [
            {
                text: 'Okay',
                handler: () => {
                    console.log('Confirm Okay');
                    if (logged) {
                      this.router.navigate(["/prenotazioni", this.id_utente]);
                    }
                }
            }
        ]
    });

    await alert.present();
}


async presentAlert() {
  const alert = await this.alertController.create({
    header: 'Error',
    subHeader: 'Dati errati',
    message: 'This is an alert message.',
    buttons: ['OK'],
  });

  await alert.present();
  let result = await alert.onDidDismiss();
  console.log(result);
}


async presentAlertError() {
  const alert = await this.alertController.create({
    header: 'Error',
    subHeader: 'Dati errati',
    message: 'I dati inseriti sono errati o incompleti - RIPROVA',
    buttons: ['OK'],
  });

  await alert.present();
  let result = await alert.onDidDismiss();
  console.log(result);
}





}
