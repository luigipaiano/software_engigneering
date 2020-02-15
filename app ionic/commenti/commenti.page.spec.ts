import { CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CommentiPage } from './commenti.page';

describe('CommentiPage', () => {
  let component: CommentiPage;
  let fixture: ComponentFixture<CommentiPage>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CommentiPage ],
      schemas: [CUSTOM_ELEMENTS_SCHEMA],
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CommentiPage);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
