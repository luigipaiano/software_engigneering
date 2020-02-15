import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { GestionePropostaComponent } from './gestione-proposta.component';

describe('GestionePropostaComponent', () => {
  let component: GestionePropostaComponent;
  let fixture: ComponentFixture<GestionePropostaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ GestionePropostaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(GestionePropostaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
