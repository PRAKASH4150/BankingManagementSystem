import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AdminComponent } from './admin/admin.component';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { AdminActionsComponent } from './admin-actions/admin-actions.component';
import { AddPlaneComponent } from './add-plane/add-plane.component';
import { AddPilotComponent } from './add-pilot/add-pilot.component';
import { AddHangarComponent } from './add-hangar/add-hangar.component';
import { ManagerRegistrationComponent } from './manager-registration/manager-registration.component';
import { ManagerListComponent } from './manager-list/manager-list.component';
import { ManagerLoginComponent } from './manager-login/manager-login.component';
import { ManagerActionsComponent } from './manager-actions/manager-actions.component';
import { ManagerHangarListComponent } from './manager-hangar-list/manager-hangar-list.component';
import { ManagerPilotListComponent } from './manager-pilot-list/manager-pilot-list.component';
import { ManagerAllPlanesListComponent } from './manager-all-planes-list/manager-all-planes-list.component';
import { AdminPilotListComponent } from './admin-pilot-list/admin-pilot-list.component';
import { AdminEditPilotComponent } from './admin-edit-pilot/admin-edit-pilot.component';
import { AdminEditPlaneComponent } from './admin-edit-plane/admin-edit-plane.component';
import { AdminPlaneListComponent } from './admin-plane-list/admin-plane-list.component';
import { NgxPaginationModule } from 'ngx-pagination';

@NgModule({
  declarations: [
    AppComponent,
    AdminComponent,
    AdminActionsComponent,
    AddPlaneComponent,
    AddPilotComponent,
    AddHangarComponent,
    ManagerRegistrationComponent,
    ManagerListComponent,
    ManagerLoginComponent,
    ManagerActionsComponent,
    ManagerHangarListComponent,
    ManagerPilotListComponent,
    ManagerAllPlanesListComponent,
    AdminPilotListComponent,
    AdminEditPilotComponent,
    AdminEditPlaneComponent,
    AdminPlaneListComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    NgxPaginationModule

  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
