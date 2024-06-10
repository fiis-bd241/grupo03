import { ComponentFixture, TestBed } from '@angular/core/testing';

import { VermigracionesComponent } from './vermigraciones.component';

describe('VermigracionesComponent', () => {
  let component: VermigracionesComponent;
  let fixture: ComponentFixture<VermigracionesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [VermigracionesComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(VermigracionesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
