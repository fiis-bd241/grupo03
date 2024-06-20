import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AgregarconceptonegocioComponent } from './agregarconceptonegocio.component';

describe('AgregarconceptonegocioComponent', () => {
  let component: AgregarconceptonegocioComponent;
  let fixture: ComponentFixture<AgregarconceptonegocioComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [AgregarconceptonegocioComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(AgregarconceptonegocioComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
