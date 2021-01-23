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
    ManagerPilotListComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
