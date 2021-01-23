import { Component, OnInit } from '@angular/core';
import { AirportService } from '../airport.service';
import { ManagerDetails } from '../manager-details';

@Component({
  selector: 'app-manager-registration',
  templateUrl: './manager-registration.component.html',
  styleUrls: ['./manager-registration.component.css']
})
export class ManagerRegistrationComponent implements OnInit {

  managerDetails:ManagerDetails=new ManagerDetails();
  submitted:Boolean=false;
  userExistenceError:String=null;
  
  constructor(private airportService:AirportService) { }

  ngOnInit() {
  }

  addMangerDetails()
  {
    this.airportService.addManagerDetails(this.managerDetails).subscribe(
      data=>
      {
        if(data==null)
        {
          this.userExistenceError="Manager with the same mobile number already exists. Try with different number"
        }
        else
        {
          console.log(data);
          this.submitted=true;
        }
        
      },
      error=>
      {
        console.error(error);
      }
    );
  }
  onSubmit()
  {
    this.addMangerDetails();
  }
}
