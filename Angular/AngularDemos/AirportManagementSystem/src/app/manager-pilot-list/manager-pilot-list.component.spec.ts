import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ManagerPilotListComponent } from './manager-pilot-list.component';

describe('ManagerPilotListComponent', () => {
  let component: ManagerPilotListComponent;
  let fixture: ComponentFixture<ManagerPilotListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ManagerPilotListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ManagerPilotListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
