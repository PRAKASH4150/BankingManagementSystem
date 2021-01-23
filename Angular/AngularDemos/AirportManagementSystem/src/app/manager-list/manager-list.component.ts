import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { AirportService } from '../airport.service';
import { ManagerDetails } from '../manager-details';

@Component({
  selector: 'app-manager-list',
  templateUrl: './manager-list.component.html',
  styleUrls: ['./manager-list.component.css']
})
export class ManagerListComponent implements OnInit {

  managerList:Observable<ManagerDetails[]>;
  constructor(private airportService:AirportService) { }

  ngOnInit() {
    this.reloadData();
  }

  reloadData()
  {
    this.managerList=this.airportService.getManagerList();
  }

  approveManager(manager:ManagerDetails)
  {
      this.airportService.aprroveManager(manager).subscribe(
      
        data =>
        {
          console.log(data);
          this.reloadData();
        },
        error =>
        {
          console.error(error);
        }
      );
      this.reloadData();
  }
  
  rejectManager(manager:ManagerDetails)
  {
    this.airportService.rejectManager(manager).subscribe(
      data =>
      {
        console.log(data);
        this.reloadData();
      },
      error =>
      {
        console.error(error);
      }
    );
    this.reloadData();
  }

}
