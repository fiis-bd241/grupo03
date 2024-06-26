import { ComponentFixture, TestBed } from '@angular/core/testing';

import { VertodoConceptosComponent } from './vertodo-conceptos.component';

describe('VertodoConceptosComponent', () => {
  let component: VertodoConceptosComponent;
  let fixture: ComponentFixture<VertodoConceptosComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [VertodoConceptosComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(VertodoConceptosComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
