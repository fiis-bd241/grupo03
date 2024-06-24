import { ComponentFixture, TestBed } from '@angular/core/testing';

import { VerReporteTareasComponent } from './verreportetareas.component';

describe('VerreportetareasComponent', () => {
  let component: VerReporteTareasComponent;
  let fixture: ComponentFixture<VerReporteTareasComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [VerReporteTareasComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(VerReporteTareasComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
