qmaApp.config(['$routeProvider', '$locationProvider', function ($routeProvider, $locationProvider) {

    $routeProvider.when('/signin', {
            templateUrl: '../components/signin/signin.html',
            controller: 'signinController'

        }).when('/signup', {
            templateUrl: '../components/signup/signup.html',
            controller: 'signupController'

        }).when('/home', {
            templateUrl: '../components/listagem-alunos/listagem-alunos.html',
            controller: 'listagemController'

    });
    $routeProvider.otherwise({redirectTo: '/signin'});
    $locationProvider.html5Mode(true);
}]);

