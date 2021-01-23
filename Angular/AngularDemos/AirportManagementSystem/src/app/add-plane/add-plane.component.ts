import { Component, OnInit } from '@angular/core';
import { AirportService } from '../airport.service';
import { PlaneDetails } from '../plane-details';

@Component({
  selector: 'app-add-plane',
  templateUrl: './add-plane.component.html',
  styleUrls: ['./add-plane.component.css']
})
export class AddPlaneComponent implements OnInit {

  planeDetails:PlaneDetails=new PlaneDetails();
  submitted:Boolean=false;

  constructor(private airportService:AirportService)
   { 

   }

  ngOnInit() {
  }

  addPlane()
  {
   this.airportService.addPlaneDetails(this.planeDetails).subscribe
  (
   data =>
   {
      console.log(data);
      this.submitted=true;
   },
   error=>
   {
      console.error(error);
   }
   );
    this.planeDetails=new PlaneDetails();
  }
  onSubmit()
  {
    this.addPlane();
  }
}
