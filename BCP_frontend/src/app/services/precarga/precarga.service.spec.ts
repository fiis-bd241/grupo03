import { TestBed } from '@angular/core/testing';

import { PrecargaService } from './precarga.service';

describe('PrecargaService', () => {
  let service: PrecargaService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(PrecargaService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
