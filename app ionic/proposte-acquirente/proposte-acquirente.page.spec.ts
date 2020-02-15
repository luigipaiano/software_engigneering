import { CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ProposteAcquirentePage } from './proposte-acquirente.page';

describe('ProposteAcquirentePage', () => {
  let component: ProposteAcquirentePage;
  let fixture: ComponentFixture<ProposteAcquirentePage>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ProposteAcquirentePage ],
      schemas: [CUSTOM_ELEMENTS_SCHEMA],
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ProposteAcquirentePage);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
