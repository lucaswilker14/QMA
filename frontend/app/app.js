// Declare app level module which depends on views, and components
var qmaApp = angular.module('qmaApp', ['ngRoute', 'ui.bootstrap', 'ngMaterial', 'ngMessages']);

//interceptador do token para controlar o que vem pelo header
qmaApp.config(function ($httpProvider) {
    $httpProvider.interceptors.push('tokenInterceptor');
})
