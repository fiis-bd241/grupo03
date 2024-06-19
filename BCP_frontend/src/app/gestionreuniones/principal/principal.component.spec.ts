import { ComponentFixture, TestBed } from '@angular/core/testing';
import {PrincipalReunionesComponent} from './principal.component';

describe('PrincipalComponent', () => {
  let component: PrincipalReunionesComponent;
  let fixture: ComponentFixture<PrincipalReunionesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [PrincipalReunionesComponent]
    })
      .compileComponents();

    fixture = TestBed.createComponent(PrincipalReunionesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
