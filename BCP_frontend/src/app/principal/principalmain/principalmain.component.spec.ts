import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PrincipalmainComponent } from './principalmain.component';

describe('PrincipalmainComponent', () => {
  let component: PrincipalmainComponent;
  let fixture: ComponentFixture<PrincipalmainComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [PrincipalmainComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PrincipalmainComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
