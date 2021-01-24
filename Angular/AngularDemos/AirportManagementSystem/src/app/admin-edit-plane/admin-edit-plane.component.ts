import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AirportService } from '../airport.service';
import { PlaneDetails } from '../plane-details';

@Component({
  selector: 'app-admin-edit-plane',
  templateUrl: './admin-edit-plane.component.html',
  styleUrls: ['./admin-edit-plane.component.css']
})
export class AdminEditPlaneComponent implements OnInit {

  planeDetails:PlaneDetails=new PlaneDetails();
  constructor(private airportService:AirportService,private router:Router) { }

  ngOnInit() {
    this.updatePlane();
  }

  updatePlane()
  {
    let planeId=localStorage.getItem("planeId");
    this.airportService.getPlaneById(+planeId).subscribe(
      data =>
      {
        this.planeDetails=data;
      }
    )
  }

  onUpdate()
  {
    this.airportService.updatePlaneDetails(this.planeDetails).subscribe(
      data =>
      {
        this.router.navigate(["admin-actions/plane-list"]);
      },
      error =>
      {
        console.log(error);
      }
    )

    this.planeDetails=new PlaneDetails();
  }
}
