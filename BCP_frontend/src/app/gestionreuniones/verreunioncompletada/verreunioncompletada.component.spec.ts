import { ComponentFixture, TestBed } from '@angular/core/testing';

import { VerreunioncompletadaComponent } from './verreunioncompletada.component';

describe('VerreunioncompletadaComponent', () => {
  let component: VerreunioncompletadaComponent;
  let fixture: ComponentFixture<VerreunioncompletadaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [VerreunioncompletadaComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(VerreunioncompletadaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
