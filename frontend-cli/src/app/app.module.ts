import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { CadastroComponent } from './cadastro/cadastro.component';
import { LoginComponent } from './login/login.component';
import { ListagemAlunosComponent } from './listagem-alunos/listagem-alunos.component';
import {routing} from './app.routing';

@NgModule({
  declarations: [
    AppComponent,
    CadastroComponent,
    LoginComponent,
    ListagemAlunosComponent
  ],
  imports: [
    BrowserModule,
    routing
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
