import { TestBed } from '@angular/core/testing';

import { AsociarTablaService } from './asociar-tabla.service';

describe('AsociarTablaService', () => {
  let service: AsociarTablaService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AsociarTablaService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
