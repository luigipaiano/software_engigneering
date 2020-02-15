import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Proposta } from 'src/app/models/proposta';
import { MyairbbService } from 'src/app/services/myairbb.service';
import { Notifica } from 'src/app/models/notifica';
import { THROW_IF_NOT_FOUND } from '@angular/core/src/di/injector';

@Component({
  selector: 'app-admin-approve',
  templateUrl: './admin-approve.component.html',
  styleUrls: ['./admin-approve.component.scss']
})
export class AdminApproveComponent implements OnInit {

  proposta: Proposta[];
  propostapp: Proposta[];
  propostapprovata: Proposta;
  id:number;
  notificacr: Notifica;


  constructor(private route: ActivatedRoute,
    private service: MyairbbService,
    private router: Router) { 
}
  ngOnInit() {

    this.propostapprovata={} as Proposta;

    this.notificacr = {} as Notifica;

    this.route.params.subscribe(params => {
      this.id=Number.parseInt(params['id']);
    })


    this.proposta = [];

    this.service.getByNonApproved().subscribe( data => {
      this.proposta=data;
    })

    this.propostapp = [];


    this.service.getByApproved().subscribe( data => {
      this.propostapp=data;
    })

  }

  approve(id_proposta: number){

    this.service.approvaProposta(id_proposta).subscribe( data=>{

    this.service.getPropostaByIdProposta(id_proposta).subscribe( data =>{

    this.propostapprovata=data;
    this.notificacr.proponente= data.proponente;
    this.notificacr.proposta=this.propostapprovata;
    this.notificacr.data=new Date();
    this.notificacr.descrizione= ("Una nuova proposta '"+ this.propostapprovata.nome+ "' è stata approvata / creata");
    this.notificacr.tipo=0;


    this.service.postNotifica(this.notificacr).subscribe( data => {
    alert("Proposta approvata !");
    window.location.reload();


    })


    })

    })
    
  }


}