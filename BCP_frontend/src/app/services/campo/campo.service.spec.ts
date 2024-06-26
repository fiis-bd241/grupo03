import { TestBed } from '@angular/core/testing';

import { CampoService } from './campo.service';

describe('CampoService', () => {
  let service: CampoService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CampoService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
