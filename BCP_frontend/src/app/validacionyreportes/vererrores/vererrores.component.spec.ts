import { ComponentFixture, TestBed } from '@angular/core/testing';

import { VererroresComponent } from './vererrores.component';

describe('VererroresComponent', () => {
  let component: VererroresComponent;
  let fixture: ComponentFixture<VererroresComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [VererroresComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(VererroresComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
