import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AgregarmigracionComponent } from './agregarmigracion.component';

describe('AgregarmigracionComponent', () => {
  let component: AgregarmigracionComponent;
  let fixture: ComponentFixture<AgregarmigracionComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [AgregarmigracionComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(AgregarmigracionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
