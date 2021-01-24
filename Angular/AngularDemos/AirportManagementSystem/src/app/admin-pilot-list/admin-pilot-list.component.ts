import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { AirportService } from '../airport.service';
import { PilotDetails } from '../pilot-details';

@Component({
  selector: 'app-admin-pilot-list',
  templateUrl: './admin-pilot-list.component.html',
  styleUrls: ['./admin-pilot-list.component.css']
})
export class AdminPilotListComponent implements OnInit {

  pilotList:Observable<PilotDetails[]>;
  count:Number=5;
  p:Number=1;
  constructor(private airportService:AirportService,private router:Router) {
   }

  ngOnInit() {
    this.reloadData();
  }

  reloadData()
  {
    this.pilotList=this.airportService.getAllPilots();
  }

  editPilot(pilot:PilotDetails):void
  {
    localStorage.setItem("pilotId",pilot.pilotId.toString());
    this.router.navigate(["edit-pilot"]);

  }
}
