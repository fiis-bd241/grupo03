import { ComponentFixture, TestBed } from '@angular/core/testing';

import { VerprogresoComponent } from './verprogreso.component';

describe('VerprogresoComponent', () => {
  let component: VerprogresoComponent;
  let fixture: ComponentFixture<VerprogresoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [VerprogresoComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(VerprogresoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
