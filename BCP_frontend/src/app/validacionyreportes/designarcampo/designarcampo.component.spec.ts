import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DesignarcampoComponent } from './designarcampo.component';

describe('DesignarcampoComponent', () => {
  let component: DesignarcampoComponent;
  let fixture: ComponentFixture<DesignarcampoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [DesignarcampoComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(DesignarcampoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
