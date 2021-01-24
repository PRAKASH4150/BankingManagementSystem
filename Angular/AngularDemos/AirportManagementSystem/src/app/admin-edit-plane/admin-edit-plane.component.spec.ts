import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminEditPlaneComponent } from './admin-edit-plane.component';

describe('AdminEditPlaneComponent', () => {
  let component: AdminEditPlaneComponent;
  let fixture: ComponentFixture<AdminEditPlaneComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AdminEditPlaneComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminEditPlaneComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
