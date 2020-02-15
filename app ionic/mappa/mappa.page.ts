import { Component, OnInit, ViewChild, AfterContentInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { MyairbbService } from '../services/myairbb.service';
declare var google;

@Component({
  selector: 'app-mappa',
  templateUrl: './mappa.page.html',
  styleUrls: ['./mappa.page.scss'],
})
export class MappaPage implements OnInit, AfterContentInit {
proposal_id: number;
acquirente_id: number;
lat1: number;
long1: number;

map;

@ViewChild('mapElement', null) mapElement;


constructor( private route: ActivatedRoute,
  private router: Router,
  private myairbbservice:MyairbbService) { }


  ngOnInit() {
    this.route.params.subscribe(params => {
      this.lat1=Number.parseInt(params['lat1']);
      this.long1=Number.parseInt(params['long1']);
      this.proposal_id=Number.parseInt(params['proposal_id']);
      this.acquirente_id=Number.parseInt(params['acquirente_id']);

    });
  }

    ngAfterContentInit(): void {
      this.map = new google.maps.Map(
          this.mapElement.nativeElement,
          {
            center: {lat: this.lat1, lng: this.long1},
            zoom: 8
          });
        }
      }


  
