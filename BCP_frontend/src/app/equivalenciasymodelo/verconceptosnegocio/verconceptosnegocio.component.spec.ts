import { ComponentFixture, TestBed } from '@angular/core/testing';

import { VerconceptosnegocioComponent } from './verconceptosnegocio.component';

describe('VerconceptosnegocioComponent', () => {
  let component: VerconceptosnegocioComponent;
  let fixture: ComponentFixture<VerconceptosnegocioComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [VerconceptosnegocioComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(VerconceptosnegocioComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
