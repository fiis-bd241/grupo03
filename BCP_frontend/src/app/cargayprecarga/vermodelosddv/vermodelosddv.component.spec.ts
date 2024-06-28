import { ComponentFixture, TestBed } from '@angular/core/testing';

import { VermodelosddvComponent } from './vermodelosddv.component';

describe('VermodelosddvComponent', () => {
  let component: VermodelosddvComponent;
  let fixture: ComponentFixture<VermodelosddvComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [VermodelosddvComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(VermodelosddvComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
