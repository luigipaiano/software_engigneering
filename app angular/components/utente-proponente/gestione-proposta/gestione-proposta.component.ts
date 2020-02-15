import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Proponente } from 'src/app/models/proponente';
import { MyairbbService } from 'src/app/services/myairbb.service';
import { Proposta } from 'src/app/models/proposta';
import { Immagine } from 'src/app/models/immagine';
import { Commento } from 'src/app/models/commento';

@Component({
  selector: 'app-gestione-proposta',
  templateUrl: './gestione-proposta.component.html',
  styleUrls: ['./gestione-proposta.component.scss']
})
export class GestionePropostaComponent implements OnInit {

  id:number;
  newProponente: Proponente;
  proponente: Proponente[];

  id2:number;
  name:string
  proposta: Proposta[];
  immagine: Immagine[];
  commento: Commento[];


  constructor(private route: ActivatedRoute,
    private service: MyairbbService,
    private router: Router) { 
}

imagePath: string = 'assets/images/casa.jpeg';

  ngOnInit() {

  this.immagine = [];
  this.commento = [];


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

    this.service.getAllImmagine().subscribe( data => {
      console.log(this.immagine);
      this.immagine=data;

    
    })

    this.service.getAllCommento().subscribe( data => {
      this.commento=data;

    });



  }

  delete(idproposta: number){

    alert("Attenzione - verranno rimossi anche le foto e i relativi commenti");

    this.service.cancellaImmagineByIdProposta(idproposta).subscribe(data=>{
    
    })

    this.service.cancellaCommentoByIdProposta(idproposta).subscribe(data=>{
    
    })

    this.service.deleteProposta(idproposta).subscribe(data=>{
    
    })

    alert("La proposta e i relativi dati sono stati rimossi correttamente");

    location.reload();
    
    }

    modifica(idproposta: number){

      this.router.navigate(['/modifica-proposta', this.id, idproposta]);
      
      }

}
