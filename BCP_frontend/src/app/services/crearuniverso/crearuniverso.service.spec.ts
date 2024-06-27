import { TestBed } from '@angular/core/testing';

import { CrearuniversoService } from './crearuniverso.service';

describe('CrearuniversoService', () => {
  let service: CrearuniversoService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CrearuniversoService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
