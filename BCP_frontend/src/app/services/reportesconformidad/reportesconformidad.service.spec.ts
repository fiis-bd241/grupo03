import { TestBed } from '@angular/core/testing';

import { ReportesconformidadService } from './reportesconformidad.service';

describe('ReportesconformidadService', () => {
  let service: ReportesconformidadService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ReportesconformidadService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
