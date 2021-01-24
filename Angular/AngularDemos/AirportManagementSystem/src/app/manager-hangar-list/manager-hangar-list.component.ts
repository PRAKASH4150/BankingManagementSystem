import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { AirportService } from '../airport.service';
import { HangarDetails } from '../hangar-details';

@Component({
  selector: 'app-manager-hangar-list',
  templateUrl: './manager-hangar-list.component.html',
  styleUrls: ['./manager-hangar-list.component.css']
})
export class ManagerHangarListComponent implements OnInit {

  hangarList:Observable<HangarDetails[]>;
  inputString:String;
  errorMessage:String;
  error:Boolean=true;
  stringData:String;
  planeId:Number;
  count:Number=5;
  p:Number=1;

  constructor(private airportService:AirportService) { }

  ngOnInit() {

    this.reloadData();
  }

  reloadData()
  {
    this.hangarList=this.airportService.getEmptyHangars();
  }

 

  allocateHangar(hangarId:Number)
  {
    this.airportService.allocateHangar(hangarId,this.planeId).subscribe(
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
          this.errorMessage="Plane with the given ID is already mapped to a hangar";
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

  onClick(hangar:HangarDetails)
  {
    this.inputString=prompt("Enter the Id of the plane to which you want to map to");
    this.planeId=+this.inputString;
    this.allocateHangar(hangar.hangarId);

  }

}
