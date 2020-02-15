import { TestBed } from '@angular/core/testing';

import { CommentiService } from './commenti.service';

describe('CommentiService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: CommentiService = TestBed.get(CommentiService);
    expect(service).toBeTruthy();
  });
});
