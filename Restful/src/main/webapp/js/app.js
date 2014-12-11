'use strict';

// Declare app level module which depends on filters, and services
angular.module('ngdemo', ['ngdemo.filters', 'ngdemo.services', 'ngdemo.directives', 'ngdemo.controllers']).
    config(['$routeProvider', function ($routeProvider) {
        $routeProvider.when('/login', {templateUrl: 'partials/partial1.html', controller: 'MyCtrl1'});
        $routeProvider.when('/home/:Id', {templateUrl: 'partials/partial2.html', controller: 'MyCtrl2'});
     
        $routeProvider.otherwise({redirectTo: '/login'});
    }]);

