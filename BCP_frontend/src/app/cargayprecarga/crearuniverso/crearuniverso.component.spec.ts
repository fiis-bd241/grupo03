import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CrearuniversoComponent } from './crearuniverso.component';

describe('CrearuniversoComponent', () => {
  let component: CrearuniversoComponent;
  let fixture: ComponentFixture<CrearuniversoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CrearuniversoComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(CrearuniversoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
