import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { AirportService } from '../airport.service';
import { PlaneDetails } from '../plane-details';

@Component({
  selector: 'app-manager-all-planes-list',
  templateUrl: './manager-all-planes-list.component.html',
  styleUrls: ['./manager-all-planes-list.component.css']
})
export class ManagerAllPlanesListComponent implements OnInit {

  planeList:Observable<PlaneDetails[]>;
  count:Number=5;
  p:Number=1;
  constructor(private airportService:AirportService) { }


  ngOnInit() {
    this.reloadData();
  }

  reloadData()
  {
    this.planeList=this.airportService.getAllPlanes();
  }

}
