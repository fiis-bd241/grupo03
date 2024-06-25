import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CancelarrreunionComponent } from './cancelarrreunion.component';

describe('CancelarrreunionComponent', () => {
  let component: CancelarrreunionComponent;
  let fixture: ComponentFixture<CancelarrreunionComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CancelarrreunionComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(CancelarrreunionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
