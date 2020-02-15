import { CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DashboardAcquirentePage } from './dashboard-acquirente.page';

describe('DashboardAcquirentePage', () => {
  let component: DashboardAcquirentePage;
  let fixture: ComponentFixture<DashboardAcquirentePage>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DashboardAcquirentePage ],
      schemas: [CUSTOM_ELEMENTS_SCHEMA],
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DashboardAcquirentePage);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
