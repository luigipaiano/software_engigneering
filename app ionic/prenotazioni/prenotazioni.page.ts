import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { MyairbbService } from '../services/myairbb.service';
import { Proposta } from '../models/proposta';
import { Prenotazione } from '../models/prenotazione';
import { Immagine } from '../models/immagine';
import { NumberValueAccessor } from '@angular/forms/src/directives';
import { Commento } from '../models/commento';
import { AlertController } from '@ionic/angular';

@Component({
  selector: 'app-prenotazioni',
  templateUrl: './prenotazioni.page.html',
  styleUrls: ['./prenotazioni.page.scss'],
})
export class PrenotazioniPage implements OnInit {

  id_acquirente:  number;
  prenotazioni: Prenotazione[];
  val:number;
  commento: Commento;
  valeue:any;

  constructor(private route: ActivatedRoute,
              private router: Router,
              private myairbbservice:MyairbbService,
              private alertController: AlertController) { }

  ngOnInit() {

    this.route.params.subscribe(params => {
      this.id_acquirente=Number.parseInt(params['acquirente_id']);

    });
    this.val=0;

    this.commento= {} as Commento;

    this.prenotazioni= [];
    this.myairbbservice.getPrenotazionebyIdAcquirente(this.id_acquirente).subscribe(data => {

      this.prenotazioni= data;

    })


  }

  sblocca(){

    this.val=1;
  }

  invia(prenotazione:Prenotazione){

    this.commento.acquirente= prenotazione.acquirente;
    this.commento.data = new Date();
    this.commento.proposta= prenotazione.proposta;
    this.commento.tipo=1;
    this.commento.val= (this.valeue)
    console.log("QUII")
    console.log("QUII")
    console.log("QUII")
    console.log("QUII")
    console.log(this.valeue)
    console.log(this.val)

    this.myairbbservice.postCommento(this.commento).subscribe(data=>{
      console.log(data);
      this.presentAlertConfirm("Messaggio Inviato!", true);
    })


  }


  async presentAlertConfirm(messageStr: string, logged: boolean) {
    const alert = await this.alertController.create({
        header: 'Invio Commento',
        message: messageStr,
        buttons: [
            {
                text: 'Okay',
                handler: () => {
                    console.log('Confirm Okay');
                    if (logged) {
                        this.val=0;
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

commenti(){
  this.router.navigate(['/commenti/', this.id_acquirente]);
}

}
