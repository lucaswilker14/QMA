qmaApp.controller('signinController', function ($scope) {

    var myIP = 'http://localhost:8080/qma/auth';

    $scope.usuarioLogin ={
        matricula: "",
        senha: ""
    }

    $scope.signin = function () {

        var req = {
            method: 'POST',
            url: myIP + '/signin',
            data: {
                usuarioLogin: $scope.usuarioLogin
            }
        }

        return $http.post(req).then(function successLogin(response){
            console.log(response.status);
        }, function errorLogin(response) {
            console.log(response.status);
        });
    }
});