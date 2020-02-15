import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { GestioneCommentiComponent } from './gestione-commenti.component';

describe('GestioneCommentiComponent', () => {
  let component: GestioneCommentiComponent;
  let fixture: ComponentFixture<GestioneCommentiComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ GestioneCommentiComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(GestioneCommentiComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
