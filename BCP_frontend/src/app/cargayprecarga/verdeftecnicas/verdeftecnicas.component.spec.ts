import { ComponentFixture, TestBed } from '@angular/core/testing';

import { VerdeftecnicasComponent } from './verdeftecnicas.component';

describe('VerdeftecnicasComponent', () => {
  let component: VerdeftecnicasComponent;
  let fixture: ComponentFixture<VerdeftecnicasComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [VerdeftecnicasComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(VerdeftecnicasComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
