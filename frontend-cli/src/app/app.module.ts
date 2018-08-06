import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppComponent} from './app.component';
import {CadastroComponent} from './cadastro/cadastro.component';
import {LoginComponent} from './login/login.component';
import {ListagemAlunosComponent} from './listagem-alunos/listagem-alunos.component';
import {AppRoutingModule} from './app.routing.module';
import {FormsModule} from '@angular/forms';
import {CadastroService} from './cadastro/cadastro.service';
import {HttpModule} from '@angular/http';

@NgModule({
  declarations: [
    AppComponent,
    CadastroComponent,
    LoginComponent,
    ListagemAlunosComponent
  ],
  imports: [
    FormsModule,
    BrowserModule,
    AppRoutingModule,
    HttpModule

  ],
  providers: [CadastroService],
  bootstrap: [AppComponent]
})
export class AppModule {
}
