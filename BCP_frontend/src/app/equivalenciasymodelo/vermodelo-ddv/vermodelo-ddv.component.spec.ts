import { ComponentFixture, TestBed } from '@angular/core/testing';

import { VermodeloDDVComponent } from './vermodelo-ddv.component';

describe('VermodeloDDVComponent', () => {
  let component: VermodeloDDVComponent;
  let fixture: ComponentFixture<VermodeloDDVComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [VermodeloDDVComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(VermodeloDDVComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
