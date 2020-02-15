import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { MyairbbService } from 'src/app/services/myairbb.service';
import { Pagamento } from 'src/app/models/pagamento';
import { Prenotazione } from 'src/app/models/prenotazione';
import { Proposta } from 'src/app/models/proposta';
import { Proponente } from 'src/app/models/proponente';

@Component({
  selector: 'app-visualizza-prenotazioni',
  templateUrl: './visualizza-prenotazioni.component.html',
  styleUrls: ['./visualizza-prenotazioni.component.scss']
})
export class VisualizzaPrenotazioniComponent implements OnInit {


  id:number;
  prenotazione: Prenotazione[];
  proposta: Proposta[];
  newProponente: Proponente;
  proponente: Proponente[];
  counter: number;
  message: string;
  

  id2:number;
  name:string


  constructor(private route: ActivatedRoute,
    private service: MyairbbService,
    private router: Router) { 
}

  ngOnInit() {


    this.counter=1;
  

    this.route.params.subscribe(params => {
      this.id=Number.parseInt(params['id']);
    });

    this.newProponente= {} as Proponente;

    this.service.getProponenteByIdProponente(this.id).subscribe(data =>{
    this.newProponente=data;

    })

    this.proposta = [];
    this.service.getPropostaByIdProponente(this.id).subscribe( data => {
      this.proposta=data;
      console.log("quiiii")
      console.log(this.proposta)

    })


    this.service.getAllPrenotazione().subscribe (data => {
      this.prenotazione=data;

    })


  }
}
