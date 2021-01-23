import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AirportService } from '../airport.service';
import { ManagerCredentials } from '../manager-credentials';

@Component({
  selector: 'app-manager-login',
  templateUrl: './manager-login.component.html',
  styleUrls: ['./manager-login.component.css']
})
export class ManagerLoginComponent implements OnInit {

  managerCred:ManagerCredentials=new ManagerCredentials();
  errorMessage:String;
  submitted:Boolean=false;
  constructor(private airportService:AirportService,private route:Router) { }

  ngOnInit() {
  }

  validateManager()
  {
    this.airportService.validateManager(this.managerCred).subscribe(
      data =>
      {
        if(data=="success")
        {
          this.route.navigate(["manager-actions"]);
        }
        else if(data=="Invalid Password")
        {
          this.errorMessage="Password is incorrect";
          this.submitted=true;
        }
        else if(data=="Pending")
        {
          this.errorMessage="Approval Status is Pending. Please wait for the admin approval";
          this.submitted=true;

        }
        else if(data=="Rejected")
        {
          this.errorMessage="Your request has been rejected";
          this.submitted=true;

        }
        else if(data=="Not exists")
        {
          this.errorMessage="Account doesn't exists.Please register first";
          this.submitted=true;

        }
      },
      error =>
      {
        console.error(error);
      }
    );
  }
  onSubmit()
  {
    this.validateManager();
  }
}
