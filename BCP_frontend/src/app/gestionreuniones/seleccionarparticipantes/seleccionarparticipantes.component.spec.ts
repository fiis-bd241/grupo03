import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SeleccionarParticipantesComponent } from './seleccionarparticipantes.component';

describe('SeleccionarparticipantesComponent', () => {
  let component: SeleccionarParticipantesComponent;
  let fixture: ComponentFixture<SeleccionarParticipantesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [SeleccionarParticipantesComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SeleccionarParticipantesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
