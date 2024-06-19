import { ComponentFixture, TestBed } from '@angular/core/testing';

import { VerreunionpendienteComponent } from './verreunionpendiente.component';

describe('VerreunionpendienteComponent', () => {
  let component: VerreunionpendienteComponent;
  let fixture: ComponentFixture<VerreunionpendienteComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [VerreunionpendienteComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(VerreunionpendienteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
