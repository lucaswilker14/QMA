import {Component, OnInit} from '@angular/core';
import {AuthService} from '../login/auth.service';

@Component({
    selector: 'app-listagem-alunos',
    templateUrl: './listagem-alunos.component.html',
    styleUrls: ['./listagem-alunos.component.css']
})
export class ListagemAlunosComponent implements OnInit {

   lista: string[];

    constructor(private loginService: AuthService) {
    }

    ngOnInit() {
        this.getAlunos();
    }

    logout() {
        this.loginService.logout();
    }

    getAlunos() {
        this.loginService.getAlunos().subscribe(res => {
            this.lista = res.json();
    });
    }
}
