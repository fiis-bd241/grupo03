import { TestBed } from '@angular/core/testing';

import { SubdominiosService } from './subdominios.service';

describe('SubdominiosService', () => {
  let service: SubdominiosService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(SubdominiosService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
