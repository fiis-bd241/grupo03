import { ComponentFixture, TestBed } from '@angular/core/testing';

import { VeruniversoComponent } from './veruniverso.component';

describe('VeruniversoComponent', () => {
  let component: VeruniversoComponent;
  let fixture: ComponentFixture<VeruniversoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [VeruniversoComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(VeruniversoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
