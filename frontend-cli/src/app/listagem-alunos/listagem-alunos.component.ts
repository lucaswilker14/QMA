import { Component, OnInit } from '@angular/core';
import {LoginService} from '../login/login.service';

@Component({
  selector: 'app-listagem-alunos',
  templateUrl: './listagem-alunos.component.html',
  styleUrls: ['./listagem-alunos.component.css']
})
export class ListagemAlunosComponent implements OnInit {

  constructor(private loginService: LoginService) { }

  ngOnInit() {
  }

  logout() {
    this.loginService.logout();
  }

}
