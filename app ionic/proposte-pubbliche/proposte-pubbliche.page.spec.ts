import { CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PropostePubblichePage } from './proposte-pubbliche.page';

describe('PropostePubblichePage', () => {
  let component: PropostePubblichePage;
  let fixture: ComponentFixture<PropostePubblichePage>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PropostePubblichePage ],
      schemas: [CUSTOM_ELEMENTS_SCHEMA],
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PropostePubblichePage);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
