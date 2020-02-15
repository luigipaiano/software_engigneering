import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Admin } from 'src/app/models/admin';
import { MyairbbService } from 'src/app/services/myairbb.service';
import { THROW_IF_NOT_FOUND } from '@angular/core/src/di/injector';
import { Utente } from 'src/app/models/utente';

@Component({
  selector: 'app-admin-home',
  templateUrl: './admin-home.component.html',
  styleUrls: ['./admin-home.component.scss']
})
export class AdminHomeComponent implements OnInit {

  id:number;
  newAdmin: Admin;
  admin: Admin[];

  id2:number;
  name:string


  constructor(private route: ActivatedRoute,
              private service: MyairbbService,
              private router: Router) { 
  }

  ngOnInit() {

    this.route.params.subscribe(params => {
      this.id=Number.parseInt(params['id']);
    });
    this.newAdmin= {} as Admin;

    this.service.getAdminByIdAmin(this.id).subscribe(data =>{
      this.newAdmin=data;
      console.log(this.newAdmin.idadmin);
    })

   
  }

}
