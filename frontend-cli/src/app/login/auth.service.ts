import { Injectable } from '@angular/core';
import {Http, RequestOptions, Headers, Response} from '@angular/http';
import {environment} from '../../environments/environment';
import {Router} from '@angular/router';
import {Observable} from 'rxjs';

@Injectable()
export class AuthService {

    private usuarioAutenticado = false;
    public token: string;
    private headers = new Headers({ 'Content-Type': 'application/json' });
    private options = new RequestOptions({ headers: this.headers });

    constructor(private http: Http, private router: Router) {
        const currentUser = JSON.parse(localStorage.getItem('currentUser'));
        this.token = currentUser && currentUser.token;
    }

    login(userCredencials: any): Observable<object> {
        const myUrl: string = environment.url + '/auth/signin';
        const request = this.http.post(myUrl, userCredencials, this.options);
        request.subscribe(response => {
            const _token = response.json().tokenType && response.json().accessToken;
            console.log(_token);
            if (_token) {
                this.token = _token;
                localStorage.setItem('currentUser', JSON.stringify({ username: userCredencials.matricula, token: _token }));
                this.usuarioAutenticado = true;
            }
        });
        return request
    }

    logout(): void {;
        // Limpa o token removendo o usuário do local store para efetuar o logout
        this.token = null;
        localStorage.removeItem('currentUser');
        this.usuarioAutenticado = false;
        this.router.navigate(['/login']);
    }

    getUsuarioAutenticado() {
        return this.usuarioAutenticado;
    }

    getAlunos() {
        const token = 'Bearer ' + JSON.parse(localStorage.getItem('currentUser')).token;
        const headers = new Headers({ 'Content-Type': 'application/json', 'Authorization': token });
        const options = new RequestOptions({ headers: headers });
        const myUrl: string = environment.url + '/aluno/listagem';
        const request = this.http.get(myUrl, options);
        return request;
    }

}
