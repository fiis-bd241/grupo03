import { TestBed } from '@angular/core/testing';

import { ModeladoService } from './modelado.service';

describe('ModeladoService', () => {
  let service: ModeladoService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ModeladoService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
