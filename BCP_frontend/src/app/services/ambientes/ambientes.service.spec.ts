import { TestBed } from '@angular/core/testing';

import { AmbientesService } from './ambientes.service';

describe('AmbientesService', () => {
  let service: AmbientesService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AmbientesService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
