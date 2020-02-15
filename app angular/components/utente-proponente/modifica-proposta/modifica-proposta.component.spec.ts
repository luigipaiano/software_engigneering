import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ModificaPropostaComponent } from './modifica-proposta.component';

describe('ModificaPropostaComponent', () => {
  let component: ModificaPropostaComponent;
  let fixture: ComponentFixture<ModificaPropostaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ModificaPropostaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ModificaPropostaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
