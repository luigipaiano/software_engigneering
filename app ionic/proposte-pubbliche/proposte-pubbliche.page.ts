import { Component, OnInit } from '@angular/core';
import { MyairbbService } from '../services/myairbb.service';
import { Immagine } from '../models/immagine';
import { Proposta } from '../models/proposta';
import { Router, ActivatedRoute } from '@angular/router';
import { Acquirente } from '../models/acquirente';

@Component({
  selector: 'app-proposte-pubbliche',
  templateUrl: './proposte-pubbliche.page.html',
  styleUrls: ['./proposte-pubbliche.page.scss'],
  providers: [ MyairbbService ]

})
export class PropostePubblichePage implements OnInit {

  
  proposte: Proposta[] = [];
  immagine: Immagine[];
  id_acquirente: number;
  newAcquirente: Acquirente;
  acquirente: Acquirente[];



  constructor(
    private router: Router,
    private route: ActivatedRoute,
    private Provider: MyairbbService
    // public navCtrl: NavController,
     //public navParams: NavParams,
   ) { }


  ngOnInit() {


    this.route.params.subscribe(params => {
      this.id_acquirente=Number.parseInt(params['acquirente_id']);

    });

    this.newAcquirente= {} as Acquirente;
    
    this.immagine = [];
    this.Provider.getByApproved().subscribe(list => {
    this.proposte = list;

    })

    this.Provider.getAllImmagine().subscribe( data => {
      console.log(this.immagine);
      this.immagine=data;

})


}


}
