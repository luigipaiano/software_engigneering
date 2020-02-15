import { Component, OnInit, ViewChild } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { MyairbbService } from '../services/myairbb.service';
import { Utente } from '../models/utente';
import { Proponente } from '../models/proponente';
import { Acquirente } from '../models/acquirente';
import { AlertController } from '@ionic/angular';
import { FormBuilder, Validators } from '@angular/forms';

@Component({
  selector: 'app-registrazione',
  templateUrl: './registrazione.page.html',
  styleUrls: ['./registrazione.page.scss'],
})
export class RegistrazionePage implements OnInit {
  @ViewChild('Userform') userForm;
  check:boolean;
  id:number;
  idproponente: number;

  utente:Utente[];
  acquirente: Acquirente[];
  utentecr: Utente;
  acquirentecr: Acquirente;
  idutente:number;
  username:string;
  password:string;

  constructor( private route: ActivatedRoute,
    private service: MyairbbService,
    private router: Router,
    private alertController: AlertController,
    public fb: FormBuilder) { 
      
    }

  ngOnInit() {

    this.utentecr = {} as Utente;
    this.acquirentecr = {} as Acquirente;
    this.acquirentecr.utente= {} as Utente;

  }

  registrati() {

    console.log(this.utentecr.username)
    this.utentecr.ultimologin= new Date();
    this.acquirentecr.utente.ultimologin=new Date();
    this.service.postUtente(this.acquirentecr.utente).subscribe( data=>{
      this.acquirentecr.utente=data;
      this.acquirentecr.utente.ultimologin=new Date();
      this.service.postAcquirente(this.acquirentecr).subscribe( data=>{
        console.log(data);
        this.presentAlert2();
        this.router.navigateByUrl("/home");

      },

      err=> {
        this.presentAlertConfirm("Errore nei dati", false);
      }
      
      
      );
        });
 
  }


  async presentAlertConfirm(messageStr: string, logged: boolean) {
    const alert = await this.alertController.create({
        header: 'Sign In',
        message: messageStr,
        buttons: [
            {
                text: 'Okay',
                handler: () => {
                    console.log('Username o email già esistenti');
                    if (logged) {
                       // this.router.navigateByUrl('firstpage/' + this.idacquirente.valueOf());
                    }
                }
            }
        ]
    });

    await alert.present();
}


async presentAlert2() {
const alert = await this.alertController.create({
  header: 'Registrazione effettuata',
  subHeader: 'Success',
  message: 'Reindirizzamento nella home...',
  buttons: ['OK'],
});

await alert.present();
}




async presentAlert() {
  const alert = await this.alertController.create({
    header: 'Error',
    subHeader: 'Username o email già esistenti',
    message: 'This is an alert message.',
    buttons: ['OK'],
  });

  await alert.present();
  let result = await alert.onDidDismiss();
  console.log(result);
}

public loginForm = this.fb.group({

  email: ["", Validators.required],
  username: ["", Validators.required],
  name: ["", Validators.required],
  surname: ["", Validators.required],
  citta: ["", Validators.required],
  indirizzo: ["", Validators.required],
  telefono: ["", Validators.required],
  password: ["", Validators.required]

});

}

