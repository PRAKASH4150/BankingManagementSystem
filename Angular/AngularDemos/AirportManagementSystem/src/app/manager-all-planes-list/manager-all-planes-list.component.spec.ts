import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ManagerAllPlanesListComponent } from './manager-all-planes-list.component';

describe('ManagerAllPlanesListComponent', () => {
  let component: ManagerAllPlanesListComponent;
  let fixture: ComponentFixture<ManagerAllPlanesListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ManagerAllPlanesListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ManagerAllPlanesListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
