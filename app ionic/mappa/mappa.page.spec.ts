import { CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MappaPage } from './mappa.page';

describe('MappaPage', () => {
  let component: MappaPage;
  let fixture: ComponentFixture<MappaPage>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MappaPage ],
      schemas: [CUSTOM_ELEMENTS_SCHEMA],
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MappaPage);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
