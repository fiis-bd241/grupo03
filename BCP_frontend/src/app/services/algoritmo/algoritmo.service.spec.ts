import { TestBed } from '@angular/core/testing';

import { AlgoritmoService } from './algoritmo.service';

describe('AlgoritmoService', () => {
  let service: AlgoritmoService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AlgoritmoService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
