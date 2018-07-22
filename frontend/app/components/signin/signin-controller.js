qmaApp.controller('signinController', function ($scope, $http) {

    var myIP = 'http://localhost:8080/qma/auth';

    $scope.usuarioLogin = {
        matricula: "",
        senha: ""
    }

    $scope.signin = function () {

        var req = {
            method: 'POST',
            url: myIP + '/signin',
            data: $scope.usuarioLogin

        }

        return $http(req).then(function successLogin(response) {
            console.log(response.status);
            console.log(response);
        }, function errorLogin(response) {
            console.log(response.status);
            console.log(response);
        });
    }
});