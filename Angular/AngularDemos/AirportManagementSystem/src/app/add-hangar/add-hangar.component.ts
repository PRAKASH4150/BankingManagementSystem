import { Component, OnInit } from '@angular/core';
import { AirportService } from '../airport.service';
import { HangarDetails } from '../hangar-details';

@Component({
  selector: 'app-add-hangar',
  templateUrl: './add-hangar.component.html',
  styleUrls: ['./add-hangar.component.css']
})
export class AddHangarComponent implements OnInit {

  hangarDetails:HangarDetails=new HangarDetails();
  submitted:Boolean=false;
  constructor(private airportService:AirportService) { }

  ngOnInit() {
  }

  addHangarDetails()
  {
    this.airportService.addHangarDetails(this.hangarDetails).subscribe(
      data=>
      {
        console.log(data);
        this.submitted=true;
      },
      error =>
      {
        console.log(error);
      }
    );
  }

  onSubmit()
  {
    this.addHangarDetails();
  }
}
