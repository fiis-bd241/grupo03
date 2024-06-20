import { ComponentFixture, TestBed } from '@angular/core/testing';

import { VerequivalenciasComponent } from './verequivalencias.component';

describe('VerequivalenciasComponent', () => {
  let component: VerequivalenciasComponent;
  let fixture: ComponentFixture<VerequivalenciasComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [VerequivalenciasComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(VerequivalenciasComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
