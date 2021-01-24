import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminEditPilotComponent } from './admin-edit-pilot.component';

describe('AdminEditPilotComponent', () => {
  let component: AdminEditPilotComponent;
  let fixture: ComponentFixture<AdminEditPilotComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AdminEditPilotComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminEditPilotComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
