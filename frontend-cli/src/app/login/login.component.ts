import {Component, OnInit} from '@angular/core';
import {AuthService} from './auth.service';
import {Router} from '@angular/router';
import {Observable} from 'rxjs';
import {error} from 'selenium-webdriver';
import {HttpErrorResponse} from '@angular/common/http';

@Component({
    selector: 'app-login',
    templateUrl: './login.component.html',
    styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

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

    login() {
        this.loginService.login(this.userCredencials).subscribe((respose) => {
            this.router.navigate(['/listagem-alunos']);
            console.log(respose['status']);
            }, (error1: HttpErrorResponse) => {
                if (error1['status'] === 404) {
                    this.error404 = true;
                } else if (error1['status'] === 400) {
                    this.error400 = true;
                }
            }
        );
    }
}
