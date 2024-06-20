import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AgregarmodeloDdvComponent } from './agregarmodelo-ddv.component';

describe('AgregarmodeloDdvComponent', () => {
  let component: AgregarmodeloDdvComponent;
  let fixture: ComponentFixture<AgregarmodeloDdvComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [AgregarmodeloDdvComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(AgregarmodeloDdvComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
