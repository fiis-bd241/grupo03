import { TestBed } from '@angular/core/testing';

import { ParticipanenService } from './participanen.service';

describe('ParticipanenService', () => {
  let service: ParticipanenService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ParticipanenService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
