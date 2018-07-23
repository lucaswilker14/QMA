qmaApp.controller("signupController", function ($scope, $http, $mdDialog, $location) {

    var myIP = 'http://localhost:8080/qma/auth';

    $scope.usuarioCadastro = {
        matricula: ""
        , nome_aluno: ""
        , codigo_curso: ""
        , email: ""
        , senha: ""
    }

    $scope.cadastrar = function () {

        var req = {
            method: 'POST',
            url: myIP + '/signup',
            data: $scope.usuarioCadastro
        }

        return $http(req).then(function successLogin(response) {
            //vai pra tela de login
            $location.path('/signin');
            //chama o popup
            $scope.alertDialog();
        }, function errorLogin(response) {
            console.log(response.status);
            console.log(response);
        });
    }

    //quando o aluno eh cadastrado com sucesso.
    $scope.alertDialog = function casdastroOK(ev){
        $mdDialog.show(
            $mdDialog.alert()
                .parent(angular.element(document.querySelector('#popupContainer')))
                .title('Bem-vindo ao QMA')
                .textContent('Aluno com matricula ' + $scope.usuarioCadastro.matricula + ' foi cadastrado com sucesso!!')
                .ok('OK')
                .targetEvent(ev)
        );
    };

});