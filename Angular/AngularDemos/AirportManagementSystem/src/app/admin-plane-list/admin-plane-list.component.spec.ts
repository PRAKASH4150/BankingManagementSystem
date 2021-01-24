import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminPlaneListComponent } from './admin-plane-list.component';

describe('AdminPlaneListComponent', () => {
  let component: AdminPlaneListComponent;
  let fixture: ComponentFixture<AdminPlaneListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AdminPlaneListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminPlaneListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
