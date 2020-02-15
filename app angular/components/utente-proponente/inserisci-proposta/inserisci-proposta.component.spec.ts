import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { InserisciPropostaComponent } from './inserisci-proposta.component';

describe('InserisciPropostaComponent', () => {
  let component: InserisciPropostaComponent;
  let fixture: ComponentFixture<InserisciPropostaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ InserisciPropostaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(InserisciPropostaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
