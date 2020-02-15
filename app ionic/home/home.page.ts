import { Component } from '@angular/core';
import {Router} from '@angular/router';
import { MyairbbService } from '../services/myairbb.service';
import { Immagine } from '../models/immagine';
import { Proposta } from '../models/proposta';

@Component({
  selector: 'app-home',
  templateUrl: 'home.page.html',
  styleUrls: ['home.page.scss'],
  providers: [ MyairbbService ]
})
export class HomePage {

  constructor(
    private router: Router,
    private Provider: MyairbbService
    
   ) { }


  ngOnInit() {


    }


}
