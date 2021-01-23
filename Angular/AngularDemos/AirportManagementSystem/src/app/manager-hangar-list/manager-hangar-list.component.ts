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
  planeId:Number;

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
          this.reloadData();
        }
        else if(data=="alreadyOccupied")
        {
          this.errorMessage="Plane with the given ID is already mapped to a hangar";
        }
         if(data=="invalidId")
        {
          this.errorMessage="Plane with the given ID doesnot exists";
        }
      },
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
