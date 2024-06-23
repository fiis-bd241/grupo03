import { TestBed } from '@angular/core/testing';

import { ListausuariosService } from './listausuarios.service';

describe('ListausuariosService', () => {
  let service: ListausuariosService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ListausuariosService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
