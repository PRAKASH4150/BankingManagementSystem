import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Admin } from '../admin';
import { AirportService } from '../airport.service';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {

  admin:Admin=new Admin();
  adminCredentialsError:String;
  submitted:Boolean=false;
  
  constructor(private airportService:AirportService,private router:Router) { }

  ngOnInit() {
  }

  validateAdmin()
  {
    this.airportService.validateAdmin(this.admin).subscribe(
      data =>
      {
        if(data==null)
        {
          this.submitted=true;
          this.adminCredentialsError="Either username or passowrd or both are invalid"
        }
        else
        {
          console.log("Submitted successfully");
          this.submitted=false;
          this.router.navigate(["admin-actions"]);
        }
      }
    )
  }
  onSubmit()
  {
    this.validateAdmin();
  }
}
