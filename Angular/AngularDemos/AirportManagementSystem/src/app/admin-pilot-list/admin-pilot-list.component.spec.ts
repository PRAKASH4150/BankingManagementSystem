import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminPilotListComponent } from './admin-pilot-list.component';

describe('AdminPilotListComponent', () => {
  let component: AdminPilotListComponent;
  let fixture: ComponentFixture<AdminPilotListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AdminPilotListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminPilotListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
