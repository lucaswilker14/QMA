qmaApp.controller("signupController", function ($scope, $http, $routeParams) {

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
            console.log(response);
            console.log(response.status);
        }, function errorLogin(response) {
            console.log(response.status);
            console.log(response);
        });
    }


})