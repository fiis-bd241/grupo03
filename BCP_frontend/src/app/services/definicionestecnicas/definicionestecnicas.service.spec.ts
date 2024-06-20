import { TestBed } from '@angular/core/testing';

import { DefinicionestecnicasService } from './definicionestecnicas.service';

describe('DefinicionestecnicasService', () => {
  let service: DefinicionestecnicasService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(DefinicionestecnicasService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
