import { TestBed } from '@angular/core/testing';

import { MyairbbService } from './myairbb.service';

describe('MyairbbService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: MyairbbService = TestBed.get(MyairbbService);
    expect(service).toBeTruthy();
  });
});
