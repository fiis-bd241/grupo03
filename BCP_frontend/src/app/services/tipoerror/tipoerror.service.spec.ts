import { TestBed } from '@angular/core/testing';

import { TipoerrorService } from './tipoerror.service';

describe('TipoerrorService', () => {
  let service: TipoerrorService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(TipoerrorService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
