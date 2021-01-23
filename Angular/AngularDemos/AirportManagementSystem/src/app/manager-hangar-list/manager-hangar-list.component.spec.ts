import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ManagerHangarListComponent } from './manager-hangar-list.component';

describe('ManagerHangarListComponent', () => {
  let component: ManagerHangarListComponent;
  let fixture: ComponentFixture<ManagerHangarListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ManagerHangarListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ManagerHangarListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
