import {Injectable} from '@angular/core';
import {environment} from '../../environments/environment';
import {Http} from '@angular/http';
import {Router} from '@angular/router';

@Injectable()
export class CadastroService {

  constructor(private http: Http, private router: Router) {}

  cadastrarAluno(aluno: any) {
    console.log(aluno);
    const myUrl: string = environment.url + '/auth/signup';
    const request = this.http.post(myUrl, aluno);
    request.subscribe(dados => {
      console.log(dados);
      this.router.navigate(['/login']);
      // this.dialog.open();
    });
  }

}
