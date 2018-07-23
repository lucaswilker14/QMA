qmaApp.controller('signinController', function ($scope, $http, $location, $mdDialog) {

    var myIP = 'http://localhost:8080/qma/auth';
    $scope.mensagem = "";

    $scope.usuarioLogin = {
        matricula: "",
        senha: ""
    }

    $scope.loginError= function (response) {

        $scope.mensagem = response.data.message;
        if (!response.data.success) {
            $scope.mensagem = response.data.message;
            $scope.alertDialog();
            return false;
        }
    }

    //popup quando matricula/senha sao invalidos
    $scope.alertDialog = function casdastroOK(ev) {
        $mdDialog.show(
            $mdDialog.alert()
                .parent(angular.element(document.querySelector('#popupContainer')))
                .title($scope.mensagem)
                .ok('OK')
                .targetEvent(ev)
        );
    };

    $scope.signin = function () {

        var req = {
            method: 'POST',
            url: myIP + '/signin',
            data: $scope.usuarioLogin
        }

        $http(req).then(function successLogin(response) {
            var token = response.data.accessToken;
            localStorage.setItem('userToken', token);
            $location.path('/home');

        }, function errorLogin(response) {
            $scope.loginError(response);
            console.log(response.status);
            console.log(response);
        });
    }
});