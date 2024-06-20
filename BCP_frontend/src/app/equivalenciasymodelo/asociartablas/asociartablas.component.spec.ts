import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AsociartablasComponent } from './asociartablas.component';

describe('AsociartablasComponent', () => {
  let component: AsociartablasComponent;
  let fixture: ComponentFixture<AsociartablasComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [AsociartablasComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(AsociartablasComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
