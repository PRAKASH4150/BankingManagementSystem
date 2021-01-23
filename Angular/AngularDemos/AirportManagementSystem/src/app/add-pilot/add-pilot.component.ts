import { Component, OnInit } from '@angular/core';
import { AirportService } from '../airport.service';
import { PilotDetails } from '../pilot-details';

@Component({
  selector: 'app-add-pilot',
  templateUrl: './add-pilot.component.html',
  styleUrls: ['./add-pilot.component.css']
})
export class AddPilotComponent implements OnInit {

  pilotDetails:PilotDetails=new PilotDetails();
  submitted:Boolean=false;

  constructor(private airportService:AirportService) { }

  ngOnInit() {
  }

  addPilotDetails()
  {
    this.airportService.addPilotDetails(this.pilotDetails).subscribe(
      data =>
      {
        console.log(data);
        this.submitted=true;
      },
      error =>
      {
        console.error(error);
      }
    );
    this.pilotDetails=new PilotDetails();
  }
  onSubmit()
  {
    this.addPilotDetails();
  }

}
