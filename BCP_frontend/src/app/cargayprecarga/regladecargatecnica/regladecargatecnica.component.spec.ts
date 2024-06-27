import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RegladecargatecnicaComponent } from './regladecargatecnica.component';

describe('RegladecargatecnicaComponent', () => {
  let component: RegladecargatecnicaComponent;
  let fixture: ComponentFixture<RegladecargatecnicaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [RegladecargatecnicaComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(RegladecargatecnicaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
