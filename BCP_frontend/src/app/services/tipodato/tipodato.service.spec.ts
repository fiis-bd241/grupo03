import { TestBed } from '@angular/core/testing';

import { TipodatoService } from './tipodato.service';

describe('TipodatoService', () => {
  let service: TipodatoService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(TipodatoService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
