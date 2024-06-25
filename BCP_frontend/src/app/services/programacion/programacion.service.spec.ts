import { TestBed } from '@angular/core/testing';

import { ProgramacionService } from './programacion.service';

describe('ProgramacionService', () => {
  let service: ProgramacionService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ProgramacionService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
