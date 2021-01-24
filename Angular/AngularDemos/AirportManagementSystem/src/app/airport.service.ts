import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { PilotDetails } from './pilot-details';
import { PlaneDetails } from './plane-details';

@Injectable({
  providedIn: 'root'
})
export class AirportService {

  private baseUrl="http://localhost:9090";

  constructor(private http:HttpClient)
   {
     
   }

   validateAdmin(admin:any):Observable<any>
   {
      return this.http.post(this.baseUrl+"/validateadminremote",admin);
   }

   addPlaneDetails(planeDetails:any):Observable<any>
   {
     return this.http.post(this.baseUrl+"/addplaneremote",planeDetails);
   }

   addPilotDetails(pilotDetails:any):Observable<any>
   {
    return this.http.post(this.baseUrl+"/addpilotremote",pilotDetails);

   }

   addHangarDetails(hangarDetails:any):Observable<any>
   {
     return this.http.post(this.baseUrl+"/addhangarremote",hangarDetails);
   }

   addManagerDetails(managerDetails:any):Observable<any>
   {
     return this.http.post(this.baseUrl+"/addmanagerremote",managerDetails);
   }

   getManagerList():Observable<any>
   {
     return this.http.get(this.baseUrl+"/getmanagersremote");
   }

   aprroveManager(manager:any):Observable<any>
   {
     return this.http.put(`${this.baseUrl}`+`/approvemanagerremote`,manager);
   }

   rejectManager(manager:any):Observable<any>
   {
     return this.http.put(`${this.baseUrl}`+`/rejectmanagerremote`,manager);
   }

   validateManager(managerCredentials:any):Observable<any>
   {
     return this.http.post(this.baseUrl+"/validatemanager",managerCredentials,{responseType: 'text'});
   }

   getEmptyHangars():Observable<any>
   {
     return this.http.get(this.baseUrl+"/getemptyhangarsremote");
   }

   allocateHangar(hangarId:Number,planeId:Number):Observable<any>
   {
     return this.http.get(this.baseUrl+"/allocatehangarremote/"+hangarId+"/"+planeId,{responseType:"text"});
   }

   getFreePilots():Observable<any>
   { 
     return this.http.get(this.baseUrl+"/getfreepilotsremote");
   }

   allocatePilot(pilotId:Number,planeId:Number):Observable<any>
   {
     return this.http.get(this.baseUrl+"/allocatepilotremote/"+pilotId+"/"+planeId,{responseType:"text"});
   }

   getAllPlanes():Observable<any>
   {
     return this.http.get(this.baseUrl+"/allremoteplanes");
   }

   getAllPilots():Observable<any>
   {
     return this.http.get(this.baseUrl+"/allremotepilots");
   }

   getPilotById(pilotId:Number):Observable<any>
   {
     return this.http.get(this.baseUrl+"/getpilotremotebyid/"+pilotId);
   }

   updatePilotDetails(pilotDetails:PilotDetails):Observable<any>
   {
     return this.http.put(this.baseUrl+"/updateremotepilot",pilotDetails);
   }

   getPlaneById(planeId:Number):Observable<any>
   {
     return this.http.get(this.baseUrl+"/getplaneremotebyid/"+planeId);
   }

   updatePlaneDetails(planeDetails:PlaneDetails):Observable<any>
   {
     return this.http.put(this.baseUrl+"/updateremoteplane",planeDetails);
   }
   
}
