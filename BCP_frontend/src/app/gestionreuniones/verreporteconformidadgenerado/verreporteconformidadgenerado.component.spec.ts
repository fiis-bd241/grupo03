import { ComponentFixture, TestBed } from '@angular/core/testing';

import { VerreporteconformidadgeneradoComponent } from './verreporteconformidadgenerado.component';

describe('VerreporteconformidadgeneradoComponent', () => {
  let component: VerreporteconformidadgeneradoComponent;
  let fixture: ComponentFixture<VerreporteconformidadgeneradoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [VerreporteconformidadgeneradoComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(VerreporteconformidadgeneradoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
