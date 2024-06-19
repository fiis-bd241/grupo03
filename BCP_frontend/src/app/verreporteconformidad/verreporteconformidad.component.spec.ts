import { ComponentFixture, TestBed } from '@angular/core/testing';

import { VerreporteconformidadComponent } from './verreporteconformidad.component';

describe('VerreporteconformidadComponent', () => {
  let component: VerreporteconformidadComponent;
  let fixture: ComponentFixture<VerreporteconformidadComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [VerreporteconformidadComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(VerreporteconformidadComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
