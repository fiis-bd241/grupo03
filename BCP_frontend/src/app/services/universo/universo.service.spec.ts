import { TestBed } from '@angular/core/testing';

import { UniversoService } from './universo.service';

describe('UniversoService', () => {
  let service: UniversoService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(UniversoService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
