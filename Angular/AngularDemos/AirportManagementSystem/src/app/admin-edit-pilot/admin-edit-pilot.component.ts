import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AirportService } from '../airport.service';
import { PilotDetails } from '../pilot-details';

@Component({
  selector: 'app-admin-edit-pilot',
  templateUrl: './admin-edit-pilot.component.html',
  styleUrls: ['./admin-edit-pilot.component.css']
})
export class AdminEditPilotComponent implements OnInit {

  pilotDetails:PilotDetails=new PilotDetails();
  constructor(private airportService:AirportService,private router:Router) { }

  ngOnInit() {
    this.updatePilot();
  }

  updatePilot()
  {
    let pilotId=localStorage.getItem("pilotId");
    this.airportService.getPilotById(+pilotId).subscribe(
      data =>
      {
        this.pilotDetails=data;
      }
    )
  }

  onUpdate()
  {
    this.airportService.updatePilotDetails(this.pilotDetails).subscribe(
      data =>
      {
        this.router.navigate(["admin-actions/pilot-list"]);
      },
      error =>
      {
        console.log(error);
      }
    )

    this.pilotDetails=new PilotDetails();
  }

}
