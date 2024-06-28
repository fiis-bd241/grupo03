import { ComponentFixture, TestBed } from '@angular/core/testing';

import { VerreglatecnicaComponent } from './verreglatecnica.component';

describe('VerreglatecnicaComponent', () => {
  let component: VerreglatecnicaComponent;
  let fixture: ComponentFixture<VerreglatecnicaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [VerreglatecnicaComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(VerreglatecnicaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
