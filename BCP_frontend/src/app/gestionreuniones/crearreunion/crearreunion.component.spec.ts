import { ComponentFixture, TestBed } from '@angular/core/testing';
import { CrearReunionComponent } from './crearreunion.component';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { FormsModule } from '@angular/forms';
import { RouterTestingModule } from '@angular/router/testing';

describe('CrearReunionComponent', () => {
  let component: CrearReunionComponent;
  let fixture: ComponentFixture<CrearReunionComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [CrearReunionComponent],
      imports: [HttpClientTestingModule, FormsModule, RouterTestingModule]
    })
      .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CrearReunionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
