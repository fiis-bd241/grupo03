import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RendimientoUsuariosComponent } from './rendimiento-usuarios.component';

describe('RendimientoUsuariosComponent', () => {
  let component: RendimientoUsuariosComponent;
  let fixture: ComponentFixture<RendimientoUsuariosComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [RendimientoUsuariosComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(RendimientoUsuariosComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
