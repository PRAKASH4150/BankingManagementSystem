import { ThrowStmt } from '@angular/compiler';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { AirportService } from '../airport.service';
import { PlaneDetails } from '../plane-details';

@Component({
  selector: 'app-admin-plane-list',
  templateUrl: './admin-plane-list.component.html',
  styleUrls: ['./admin-plane-list.component.css']
})
export class AdminPlaneListComponent implements OnInit {

  planeList:Observable<PlaneDetails[]>;
  count:Number=5;
  p:Number=1;

  constructor(private airportService:AirportService,private router:Router)
  { 

  }

  ngOnInit() {
    this.reloadData();
  }

  reloadData()
  {
    this.planeList=this.airportService.getAllPlanes();
  }

  editPlane(plane:PlaneDetails)
  {
    localStorage.setItem("planeId",plane.planeId.toString());
    this.router.navigate(["edit-plane"]);
  }
}
