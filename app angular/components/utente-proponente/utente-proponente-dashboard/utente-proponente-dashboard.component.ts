import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Proponente } from 'src/app/models/proponente';
import { MyairbbService } from 'src/app/services/myairbb.service';
import { Proposta } from 'src/app/models/proposta';
import { Immagine } from 'src/app/models/immagine';
import { Notifica } from 'src/app/models/notifica';

@Component({
  selector: 'app-utente-proponente-dashboard',
  templateUrl: './utente-proponente-dashboard.component.html',
  styleUrls: ['./utente-proponente-dashboard.component.scss']
})
export class UtenteProponenteDashboardComponent implements OnInit {

  id:number;
  newProponente: Proponente;
  proponente: Proponente[];

  id2:number;
  name:string
  proposta: Proposta[];
  notifica: Notifica[];


  constructor(private route: ActivatedRoute,
    private service: MyairbbService,
    private router: Router) { 
}

imagePath: string = 'assets/images/casa.jpeg';

  ngOnInit() {
  
  this.notifica = [];


    this.route.params.subscribe(params => {
      this.id=Number.parseInt(params['id']);
    });


    this.proposta = [];
    this.service.getPropostaByIdProponente(this.id).subscribe( data => {
      this.proposta=data; 
    })

    this.newProponente= {} as Proponente;

    this.service.getProponenteByIdProponente(this.id).subscribe(data =>{
    this.newProponente=data;

    })

    this.service.getNotificaByIdProponente(this.id).subscribe( data => {
    this.notifica=data;


    })


  }


  delete(idnotifica: number){
    this.service.deleteNotifica(idnotifica).subscribe(data=>{
      console.log(idnotifica)
      alert("Notifica eliminata !");

    })

    }

}
