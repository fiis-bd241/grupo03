import { ComponentFixture, TestBed } from '@angular/core/testing';

import { VerreportetareasComponent } from './verreportetareas.component';

describe('VerreportetareasComponent', () => {
  let component: VerreportetareasComponent;
  let fixture: ComponentFixture<VerreportetareasComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [VerreportetareasComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(VerreportetareasComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
