import {Component, OnInit, ViewChild} from '@angular/core';
import {Router} from '@angular/router';
import {AlertController} from '@ionic/angular';
import { Acquirente } from '../models/acquirente';
import { MyairbbService } from '../services/myairbb.service';
import { analyzeAndValidateNgModules, collectExternalReferences } from '@angular/compiler';
import {
  GoogleMaps,
  GoogleMap,
  GoogleMapsEvent,
  GoogleMapOptions,
  CameraPosition,
  MarkerOptions,
  Marker,
  Environment
} from '@ionic-native/google-maps';

@Component({
  selector: 'app-login',
  templateUrl: './login.page.html',
  styleUrls: ['./login.page.scss'],
  providers: [ MyairbbService ]

})
export class LoginPage implements OnInit {
  map: GoogleMap;
  @ViewChild('Userform') userForm;
  @ViewChild('username') username;
  @ViewChild('password') password;


  check:boolean;
  acquirente: Acquirente[];
  id:number;
  idacquirente: number;
  isacquirente: number;



  constructor(private router: Router,
              private Provider: MyairbbService,
              private alertController: AlertController) { }

  ngOnInit() {

    this.acquirente = [];
    this.isacquirente=0
  }

  signIn() {

    this.Provider.getAcquirenteByUsernameAndPassword(this.username.value, this.password.value).subscribe((data: any) => {
     
      console.log(this.username);
      console.log(this.password)

      this.idacquirente=data.idacquirente;
        this.presentAlertConfirm('Sarai reindirizzato nella dashboard', true);
        this.router.navigate(['/dashboard-acquirente', this.idacquirente]);
      },

      err =>{

        this.presentAlert();
      
    });
   
       
  }

    async presentAlertConfirm(messageStr: string, logged: boolean) {
        const alert = await this.alertController.create({
            header: 'Accesso Effettuato',
            message: messageStr,
            buttons: [
                {
                    text: 'Ok',
                    handler: () => {
                        if (logged) {
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

}
