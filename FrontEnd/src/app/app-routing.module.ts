import { HomeComponent } from './views/home/home/home.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { PessoaAlterarComponent } from './views/pessoa/pessoa-alterar/pessoa-alterar.component';
import { PessoaListaComponent } from './views/pessoa/pessoa-lista/pessoa-lista.component';
import { PessoaNovoComponent } from './views/pessoa/pessoa-novo/pessoa-novo.component';

const routes: Routes = [
  {
    path: '',
    component: HomeComponent
  },
  {
    path: 'pessoas',
    component: PessoaListaComponent
  },
  {
    path: 'pessoas/novo',
    component: PessoaNovoComponent
  },
  {
    path: 'pessoas/alterar/:id',
    component: PessoaAlterarComponent
  }
];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
