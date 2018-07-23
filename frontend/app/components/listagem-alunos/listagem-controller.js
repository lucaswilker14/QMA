qmaApp.controller('listagemController', function ($scope, $http, $location, $mdDialog) {

    var myIP = 'http://localhost:8080/qma/aluno';
    $scope.alunos = [];

    var req = {
        method: 'GET',
        url: myIP + '/listagem'
    }

    //funcao para carregar a listagem de alunos do bd
    $scope.carregar = function () {

        $scope.alertDialog();

        $http(req).then(function success(response){
            console.log(response);
            console.log(response.status);
            $scope.alunos = response.data;

            }, function error(response) {
            console.log(response);
            console.log(response.status);
        });
    };

    $scope.logout = function(){
        localStorage.clear();
        $location.path('/signin');
    }

    //quando o aluno consegue se logar com sucesso.
    $scope.alertDialog = function casdastroOK(ev){
        $mdDialog.show(
            $mdDialog.alert()
                .parent(angular.element(document.querySelector('#popupContainer')))
                .title('Autenticado com Sucesso!')
                // .textContent('Aluno com matricula ' + $scope.usuarioCadastro.matricula + ' foi cadastrado com sucesso!!')
                .ok('OK')
                .targetEvent(ev)
        );
    };

    $scope.carregar();
});
