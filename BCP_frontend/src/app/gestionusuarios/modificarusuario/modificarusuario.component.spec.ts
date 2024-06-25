import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ModificarusuarioComponent } from './modificarusuario.component';

describe('ModificarusuarioComponent', () => {
  let component: ModificarusuarioComponent;
  let fixture: ComponentFixture<ModificarusuarioComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ModificarusuarioComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(ModificarusuarioComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
