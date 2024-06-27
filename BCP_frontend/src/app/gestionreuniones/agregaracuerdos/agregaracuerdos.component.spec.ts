import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AgregaracuerdosComponent } from './agregaracuerdos.component';

describe('AgregaracuerdosComponent', () => {
  let component: AgregaracuerdosComponent;
  let fixture: ComponentFixture<AgregaracuerdosComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [AgregaracuerdosComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(AgregaracuerdosComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
