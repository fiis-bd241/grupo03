import { ComponentFixture, TestBed } from '@angular/core/testing';

import { VerpedidosmainComponent } from './verpedidosmain.component';

describe('VerpedidosmainComponent', () => {
  let component: VerpedidosmainComponent;
  let fixture: ComponentFixture<VerpedidosmainComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [VerpedidosmainComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(VerpedidosmainComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
