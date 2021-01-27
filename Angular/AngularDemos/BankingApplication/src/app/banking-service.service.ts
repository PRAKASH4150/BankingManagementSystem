import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { User } from './User';

@Injectable({
  providedIn: 'root'
})
export class BankingServiceService {

  private baseUrl="http://localhost:8080"

  constructor(private http:HttpClient) 
  {

  }

  getByUserName(userName:String):Observable<any>
  {
    return this.http.get(this.baseUrl+"/getbyusername/"+userName);
  }

  createUser(user:User):Observable<any>
  {
    return this.http.post(this.baseUrl+"/createuseer",user);
  }
}
