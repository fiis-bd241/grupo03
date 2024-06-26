import { ComponentFixture, TestBed } from '@angular/core/testing';

import { VermigracionesmainComponent } from './vermigracionesmain.component';

describe('VermigracionesmainComponent', () => {
  let component: VermigracionesmainComponent;
  let fixture: ComponentFixture<VermigracionesmainComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [VermigracionesmainComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(VermigracionesmainComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
