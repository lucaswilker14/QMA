qmaApp.config(['$routeProvider', '$locationProvider', function ($routeProvider, $locationProvider) {

    $routeProvider.when('/signin', {

        templateUrl: '../components/signin/signin.html',
        controller: 'signinController'

    }).when('/signup', {
        templateUrl: '../components/signup/signup.html',
        controller: 'signupController'
    });

    $routeProvider.otherwise({redirectTo: '/signin'});
    $locationProvider.html5Mode(true);
}]);