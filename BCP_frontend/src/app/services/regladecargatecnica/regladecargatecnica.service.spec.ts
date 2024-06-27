import { TestBed } from '@angular/core/testing';

import { RegladecargatecnicaService } from './regladecargatecnica.service';

describe('RegladecargatecnicaService', () => {
  let service: RegladecargatecnicaService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(RegladecargatecnicaService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
