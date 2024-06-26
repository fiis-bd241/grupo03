import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListareportesconformidadComponent } from './listareportesconformidad.component';

describe('ListareportesconformidadComponent', () => {
  let component: ListareportesconformidadComponent;
  let fixture: ComponentFixture<ListareportesconformidadComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ListareportesconformidadComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(ListareportesconformidadComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
