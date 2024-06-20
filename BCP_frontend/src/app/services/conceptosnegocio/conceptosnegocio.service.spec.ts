import { TestBed } from '@angular/core/testing';

import { ConceptosnegocioService } from './conceptosnegocio.service';

describe('ConceptosnegocioService', () => {
  let service: ConceptosnegocioService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ConceptosnegocioService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
