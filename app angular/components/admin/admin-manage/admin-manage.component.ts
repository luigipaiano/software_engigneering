import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { MyairbbService } from 'src/app/services/myairbb.service';
import { Beneservizio } from 'src/app/models/beneservizio';


@Component({
  selector: 'app-admin-manage',
  templateUrl: './admin-manage.component.html',
  styleUrls: ['./admin-manage.component.scss']
})
export class AdminManageComponent implements OnInit {

  beneservizio: Beneservizio[];
  id:number;
  beneserviziocr: Beneservizio;
  submitted = false;


  constructor(
    private route: ActivatedRoute,
    private service: MyairbbService,
    private router: Router) {}


  ngOnInit() {

    this.beneservizio = [];
    this.beneserviziocr = {} as Beneservizio;

    this.service.getAllABeneservizio().subscribe( data => {
    this.beneservizio=data;
    });
   
    this.route.params.subscribe(params => {
      this.id=Number.parseInt(params['id']);
    });
    

  }

    delete(idbeneservizio: number){
      this.service.deleteBeneservizio(idbeneservizio).subscribe(data=>{
        console.log(data)
        alert("Bene / servizio rimosso con successo");
        this.service.getAllABeneservizio().subscribe( data => {
          this.beneservizio=data;
        }
      );
    },

    err =>{
      if(err.status != 200){
        alert("Attenzione ! Esistono proposte collegate a questa categoria !")
      }
      });
      
      }
      
    inserisci(){
      this.service.postBeneservizio(this.beneserviziocr).subscribe( data=>{
        alert("Categoria aggiunta con successo !")
      window.location.reload();
        })
        }

  }



  
  