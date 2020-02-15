import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UtenteProponenteDashboardComponent } from './utente-proponente-dashboard.component';

describe('UtenteProponenteDashboardComponent', () => {
  let component: UtenteProponenteDashboardComponent;
  let fixture: ComponentFixture<UtenteProponenteDashboardComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UtenteProponenteDashboardComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UtenteProponenteDashboardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
