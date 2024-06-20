import { TestBed } from '@angular/core/testing';

import { EsquemasService } from './esquemas.service';

describe('EsquemasService', () => {
  let service: EsquemasService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(EsquemasService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
