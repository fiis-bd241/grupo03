import { TestBed } from '@angular/core/testing';

import { MigracionesService } from './migraciones.service';

describe('MigracionesService', () => {
  let service: MigracionesService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(MigracionesService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
