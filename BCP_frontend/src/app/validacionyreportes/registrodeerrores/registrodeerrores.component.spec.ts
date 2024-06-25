import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RegistrodeerroresComponent } from './registrodeerrores.component';

describe('RegistrodeerroresComponent', () => {
  let component: RegistrodeerroresComponent;
  let fixture: ComponentFixture<RegistrodeerroresComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [RegistrodeerroresComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(RegistrodeerroresComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
