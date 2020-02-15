import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { MyairbbService } from '../services/myairbb.service';
import { Commento } from '../models/commento';

@Component({
  selector: 'app-commenti',
  templateUrl: './commenti.page.html',
  styleUrls: ['./commenti.page.scss'],
})
export class CommentiPage implements OnInit {

  id_acquirente: number;
  commenti: Commento[];
  

  constructor(private route: ActivatedRoute,
    private router: Router,
    private myairbbservice:MyairbbService) { }

  ngOnInit() {

    this.route.params.subscribe(params => {
      this.id_acquirente=Number.parseInt(params['user_id']);

    });

    this.myairbbservice.getAllCommento().subscribe(data=> {

      this.commenti= data;
      console.log("commenti"+ data)


    })

    





  }

}
