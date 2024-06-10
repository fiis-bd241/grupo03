import { ComponentFixture, TestBed } from '@angular/core/testing';

import { VerpedidosComponent } from './verpedidos.component';

describe('VerpedidosComponent', () => {
  let component: VerpedidosComponent;
  let fixture: ComponentFixture<VerpedidosComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [VerpedidosComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(VerpedidosComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
