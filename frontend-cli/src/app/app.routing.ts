import {ModuleWithProviders} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';

import {LoginComponent} from './login/login.component';
import {CadastroComponent} from './cadastro/cadastro.component';
import {ListagemAlunosComponent} from './listagem-alunos/listagem-alunos.component';

const APP_ROUTES: Routes = [
  { path: '', component: LoginComponent},
  { path: 'login', component: LoginComponent},
  { path: 'cadastro', component: CadastroComponent},
  { path: 'listagem-alunos', component: ListagemAlunosComponent}
];


export const routing: ModuleWithProviders = RouterModule.forRoot(APP_ROUTES);
