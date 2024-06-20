import { TestBed } from '@angular/core/testing';

import { TiposreunionService } from './tiposreunion.service';

describe('TiposreunionService', () => {
  let service: TiposreunionService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(TiposreunionService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
