import { Component, OnInit, ViewChild } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { MyairbbService } from 'src/app/services/myairbb.service';
import { Admin } from 'src/app/models/admin';
import { switchMap } from 'rxjs/operators';
import { Beneservizio } from 'src/app/models/beneservizio';
import { Proponente } from 'src/app/models/proponente';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  @ViewChild('Userform') userForm;

  check:boolean;
  admin: Admin[];
  proponente: Proponente[];
  id:number;
  idadmin:number;
  idproponente: number;
  isadmin:number;
  isproponente: number;


  username:string;
  password:string;

  constructor( private route: ActivatedRoute,
    private service: MyairbbService,
    private router: Router) { 
      
    }

  ngOnInit() {

    this.proponente = [];
    this.admin = [];
    this.isproponente=0
    this.isadmin=0


    
  }

  onSubmit() {
    
    this.service.getAdminByUsernameAndPassword(this.username.valueOf(), this.password.valueOf()).subscribe( (data : any)=>{

    this.idadmin= data.idadmin;

    if (this.idadmin != 0) 
    {
      this.isadmin=1;
      console.log(this.isadmin)

      this.router.navigate(['/admin-home', this.idadmin]);
    } 
    // provo up

   

      },
      error => {

          this.service.getProponenteByUsernameAndPassword(this.username.valueOf(), this.password.valueOf()).subscribe( (data : any)=>{
          
            this.idproponente= data.idproponente;
        
      
            if (this.idproponente != 0) 
            {
              this.isproponente=1;
              this.router.navigate(['/utente-proponente-dashboard', this.idproponente]);
            } 
      
            
        
           },
           error => {
    
              alert("Dati errati");
              

           } );

    });

 
  }
  

}