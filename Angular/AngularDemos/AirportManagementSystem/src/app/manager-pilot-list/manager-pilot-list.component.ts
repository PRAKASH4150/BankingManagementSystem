import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { AirportService } from '../airport.service';
import { HangarDetails } from '../hangar-details';
import { PilotDetails } from '../pilot-details';

@Component({
  selector: 'app-manager-pilot-list',
  templateUrl: './manager-pilot-list.component.html',
  styleUrls: ['./manager-pilot-list.component.css']
})
export class ManagerPilotListComponent implements OnInit {

  pilotList:Observable<PilotDetails[]>;
  inputString:String;
  planeId:Number;
  errorMessage:String;
  error:Boolean=true;
  count:Number=5;
  p:Number=1;
  constructor(private airportService:AirportService) { }

  ngOnInit() {

    this.reloadData();
  }

  reloadData()
  {
    this.pilotList=this.airportService.getFreePilots();
  }

  allocatePilot(pilotId:Number)
  {
    this.airportService.allocatePilot(pilotId,this.planeId).subscribe(
      data =>
      {
        if(data=="success")
        {
          console.log("Innner");
          this.reloadData();
          this.error=true;
        } 
        else if(data=="alreadyOccupied")
        {
          console.log("Inside");
          this.errorMessage="Plane with the given ID is already mapped to a pilot";
          this.error=false;
        }
        else if(data=="invalidId")
        {
          this.errorMessage="Plane with the given ID doesnot exists";
          this.error=false;

        }
      },
      error =>
      {
        console.error(error);
        
      }
    );
    this.reloadData();
  }
  onClick(pilot:PilotDetails)
  {
    this.inputString=prompt("Enter the Plane Id to which you want to map the pilot");
    this.planeId=+ this.inputString;
    this.allocatePilot(pilot.pilotId);
  }

}
