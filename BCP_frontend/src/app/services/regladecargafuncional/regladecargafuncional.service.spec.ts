import { TestBed } from '@angular/core/testing';

import { RegladecargafuncionalService } from './regladecargafuncional.service';

describe('RegladecargafuncionalService', () => {
  let service: RegladecargafuncionalService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(RegladecargafuncionalService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
