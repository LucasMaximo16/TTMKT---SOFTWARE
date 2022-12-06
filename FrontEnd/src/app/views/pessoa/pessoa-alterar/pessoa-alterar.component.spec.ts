import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PessoaAlterarComponent } from './pessoa-alterar.component';

describe('PessoaAlterarComponent', () => {
  let component: PessoaAlterarComponent;
  let fixture: ComponentFixture<PessoaAlterarComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PessoaAlterarComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PessoaAlterarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
