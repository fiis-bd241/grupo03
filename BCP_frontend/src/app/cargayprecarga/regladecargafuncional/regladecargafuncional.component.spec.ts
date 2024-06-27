import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RegladecargafuncionalComponent } from './regladecargafuncional.component';

describe('RegladecargafuncionalComponent', () => {
  let component: RegladecargafuncionalComponent;
  let fixture: ComponentFixture<RegladecargafuncionalComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [RegladecargafuncionalComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(RegladecargafuncionalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
