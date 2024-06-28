import { ComponentFixture, TestBed } from '@angular/core/testing';

import { VerreglafuncionalComponent } from './verreglafuncional.component';

describe('VerreglafuncionalComponent', () => {
  let component: VerreglafuncionalComponent;
  let fixture: ComponentFixture<VerreglafuncionalComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [VerreglafuncionalComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(VerreglafuncionalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
