import { Component, OnInit } from '@angular/core';
import {AuthService} from '../login/auth.service';

@Component({
  selector: 'app-listagem-alunos',
  templateUrl: './listagem-alunos.component.html',
  styleUrls: ['./listagem-alunos.component.css']
})
export class ListagemAlunosComponent implements OnInit {

  constructor(private loginService: AuthService) { }

  ngOnInit() {
  }

  logout() {
    this.loginService.logout();
  }

}
