import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PrecargaComponent } from './precarga.component';

describe('PrecargaComponent', () => {
  let component: PrecargaComponent;
  let fixture: ComponentFixture<PrecargaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [PrecargaComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(PrecargaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
