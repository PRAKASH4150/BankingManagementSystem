import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AddHangarComponent } from './add-hangar/add-hangar.component';
import { AddPilotComponent } from './add-pilot/add-pilot.component';
import { AddPlaneComponent } from './add-plane/add-plane.component';
import { AdminActionsComponent } from './admin-actions/admin-actions.component';
import { AdminEditPilotComponent } from './admin-edit-pilot/admin-edit-pilot.component';
import { AdminEditPlaneComponent } from './admin-edit-plane/admin-edit-plane.component';
import { AdminPilotListComponent } from './admin-pilot-list/admin-pilot-list.component';
import { AdminPlaneListComponent } from './admin-plane-list/admin-plane-list.component';
import { AdminComponent } from './admin/admin.component';
import { ManagerActionsComponent } from './manager-actions/manager-actions.component';
import { ManagerAllPlanesListComponent } from './manager-all-planes-list/manager-all-planes-list.component';
import { ManagerHangarListComponent } from './manager-hangar-list/manager-hangar-list.component';
import { ManagerListComponent } from './manager-list/manager-list.component';
import { ManagerLoginComponent } from './manager-login/manager-login.component';
import { ManagerPilotListComponent } from './manager-pilot-list/manager-pilot-list.component';
import { ManagerRegistrationComponent } from './manager-registration/manager-registration.component';


const routes: Routes = [
  {
    path:"adminlogin",
    component:AdminComponent
  },
  {
    path:"admin-actions",
    component:AdminActionsComponent,
    children:[
      {
        path:"add-plane",
        component:AddPlaneComponent
      },
      {
        path:"add-pilot",
        component:AddPilotComponent
      },
      {
        path:"add-hangar",
        component:AddHangarComponent
      },
      {
        path:"manager-list",
        component:ManagerListComponent
      },
      {
        path:"pilot-list",
        component:AdminPilotListComponent,
      },
      {
        path:"plane-list",
        component:AdminPlaneListComponent
      }
    ]
  },
  {
    path:"edit-pilot",
    component:AdminEditPilotComponent
  },
  {
    path:"edit-plane",
    component:AdminEditPlaneComponent
  },
  {
    path:"manager-registration",
    component:ManagerRegistrationComponent
  },
  {
    path:"manager-login",
    component:ManagerLoginComponent
  },
  {
    path:"manager-actions",
    component:ManagerActionsComponent,
    children:[
      {
        path:"manager-hangar",
        component:ManagerHangarListComponent
      },
      {
        path:"manager-pilot",
        component:ManagerPilotListComponent
      },
      {
        path:"manager-all-planes",
        component:ManagerAllPlanesListComponent
      }
    ]
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
