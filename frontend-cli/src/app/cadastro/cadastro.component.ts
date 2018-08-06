import { Component, OnInit } from '@angular/core';
import {CadastroService} from './cadastro.service';
// import {Http} from '@angular/http';

@Component({
  selector: 'app-cadastro',
  templateUrl: './cadastro.component.html',
  styleUrls: ['./cadastro.component.css']
})
export class CadastroComponent implements OnInit {

  sobrenome = '';
  aluno: any = {
    matricula: '',
    nome_aluno: '',
    codigo_curso: '',
    telefone: null,
    email: '',
    senha: ''
  };

  constructor(
    private cadastroService: CadastroService) { }

  ngOnInit() {
  }

  cadastrarAluno() {
    // console.log(this.aluno);
    this.aluno.nome_aluno = this.aluno.nome_aluno + ' ' + this.sobrenome;
    this.cadastroService.cadastrarAluno(this.aluno);
  }

}
