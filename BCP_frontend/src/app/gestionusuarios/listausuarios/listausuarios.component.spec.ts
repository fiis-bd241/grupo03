import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListaUsuariosComponent } from './listausuarios.component';

describe('ListaUsuariosComponent', () => {
  let component: ListaUsuariosComponent;
  let fixture: ComponentFixture<ListaUsuariosComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [] 
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(ListaUsuariosComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
