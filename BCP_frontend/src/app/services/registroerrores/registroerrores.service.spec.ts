import { TestBed } from '@angular/core/testing';

import { RegistroerroresService } from './registroerrores.service';

describe('RegistroerroresService', () => {
  let service: RegistroerroresService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(RegistroerroresService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
