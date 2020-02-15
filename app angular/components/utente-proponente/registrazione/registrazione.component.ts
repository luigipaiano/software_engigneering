import { Component, OnInit, ViewChild } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { MyairbbService } from 'src/app/services/myairbb.service';
import { Proponente } from 'src/app/models/proponente';
import { Utente } from 'src/app/models/utente';
import { Proposta } from 'src/app/models/proposta';

@Component({
  selector: 'app-registrazione',
  templateUrl: './registrazione.component.html',
  styleUrls: ['./registrazione.component.scss']
})
export class RegistrazioneComponent implements OnInit {
  @ViewChild('Userform') userForm;

  check:boolean;
  id:number;
  idproponente: number;

  utente:Utente[];
  proponente: Proponente[];
  utentecr: Utente;
  proponentecr: Proponente;
  idutente:number;
  username:string;
  password:string;

  constructor( private route: ActivatedRoute,
    private service: MyairbbService,
    private router: Router) { 
      
    }

  ngOnInit() {

    this.utentecr = {} as Utente;
    this.proponentecr = {} as Proponente;

  }

  registrati() {
    this.utentecr.ultimologin=new Date();

    this.service.postUtente(this.utentecr).subscribe( data=>{
      this.proponentecr.utente=data;

      this.proponentecr.utente.ultimologin= new Date();

      this.service.postProponente(this.proponentecr).subscribe( data=>{
        console.log(data)
        alert("registrazione effettuata con successo - Reindirizzamento Home")
        this.router.navigate(["/"]);


      });
        });
 
  }

}
