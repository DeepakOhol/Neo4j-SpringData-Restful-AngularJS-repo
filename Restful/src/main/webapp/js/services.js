'use strict';

/* Services */

/*var services = angular.module('ngdemo.services', ['ngResource']);

services.factory('UserFactory', function ($resource) {
    return $resource('/ngdemo/rest/users', {}, {
        query: {
            method: 'GET',
            params: {},
            isArray: false
        }
    });
});*/
var services = angular.module('ngdemo.services', ['ngResource']);
   services.factory('UserFactory', function ($http) {
		   var factory = {};
		   factory.loggedIn = function(data) {
			   return $http.post('/Restful/rest/customer/login',data);  
		   };
		   factory.getHome = function(Id) {
			   return $http.get('/Restful/rest/customer/home/'+Id);  
		   };
		   factory.create = function(data) {
			   return $http.post('/Restful/rest/customer/register', data); 
			   };
	       return factory;
	       });