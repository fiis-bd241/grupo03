import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BuscarreporteComponent } from './buscarreporte.component';

describe('BuscarreporteComponent', () => {
  let component: BuscarreporteComponent;
  let fixture: ComponentFixture<BuscarreporteComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [BuscarreporteComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(BuscarreporteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
