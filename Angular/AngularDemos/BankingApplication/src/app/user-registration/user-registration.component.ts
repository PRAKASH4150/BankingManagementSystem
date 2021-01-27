import { Component, Input, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { BankingServiceService } from '../banking-service.service';
import { User } from '../User';

@Component({
  selector: 'app-user-registration',
  templateUrl: './user-registration.component.html',
  styleUrls: ['./user-registration.component.css']
})
export class UserRegistrationComponent implements OnInit {

  user:User=new User();
  constructor(private bankingService:BankingServiceService,private route:Router) { }
  userExistenceError:String;
  ngOnInit() {
  }

  checkByUserName()
  {
    this.bankingService.getByUserName(this.user.userName).subscribe(

      data =>
      {
        if(data!=null)
        {
          this.bankingService.createUser(this.user).subscribe(
            data =>
            {
              this.route.navigate(["user-login"]);
            },
            error =>
            {
              console.log(error);
            }
          )
          
        }
        else if(data==null)
        { 
          this.userExistenceError="User with the same username already exists. Try using a different username";
        }
      }
    );
  }
  onSubmit()
  {

  }
}
