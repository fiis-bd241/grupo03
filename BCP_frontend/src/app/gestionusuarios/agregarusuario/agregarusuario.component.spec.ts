import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AgregarUsuarioComponent } from './agregarusuario.component';

describe('AgregarUsuarioComponent', () => {
  let component: AgregarUsuarioComponent;
  let fixture: ComponentFixture<AgregarUsuarioComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [AgregarUsuarioComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(AgregarUsuarioComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
