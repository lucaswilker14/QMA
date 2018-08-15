import {Component, OnChanges, OnInit} from '@angular/core';
import {AuthService} from './auth.service';
import {Router} from '@angular/router';
import {HttpErrorResponse} from '@angular/common/http';
import * as $ from 'node_modules/jquery';


@Component({
    selector: 'app-login',
    templateUrl: './login.component.html',
    styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit, OnChanges {

    userCredencials: any = {
        matricula: '',
        senha: ''
    };

    error404 = false; //erro pra matricula
    error400 = false; //erro pra senha

    constructor(private loginService: AuthService, private router: Router) {
    }

    ngOnInit() {
    }

    ngOnChanges(): void {
        this.error404 = false;
        this.error400 = false;
    }



    login() {
        this.loginService.login(this.userCredencials).subscribe((respose) => {
            this.router.navigate(['/listagem-alunos']);
            console.log(respose['status']);
            },
            (error1: HttpErrorResponse) => {
            if (error1['status'] === 404) {
                this.error404 = true;
            } else if (error1['status'] === 400) {
                this.error400 = true;
            }
            }
        );
    }
    changeError404() {
        this.error404 = false;
    }

    changeError400() {
        this.error400 = false;
    }

}
