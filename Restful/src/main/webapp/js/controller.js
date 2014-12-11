'use strict';

/* Controllers */


var app = angular.module('ngdemo.controllers', []);


// Clear browser cache (in development mode)
//
// http://stackoverflow.com/questions/14718826/angularjs-disable-partial-caching-on-dev-machine
app.run(function ($rootScope, $templateCache) {
    $rootScope.$on('$viewContentLoaded', function () {
        $templateCache.removeAll();
    });
});





app.controller('MyCtrl1', ['$scope', 'UserFactory','$location','$window', function ($scope, UserFactory,$location,$window) {
    $scope.name = 'bla from controller';
    
    $scope.info = {
    		        UserName: '',
    				password:'',
    				reenterPassword:''
    		      };
    $scope.login = {
    	username: "",
    	password:""
    };
    $scope.createAccount = function(){
    	var info = $scope.info;
    	$scope.clear = false;
    	if(info.password!=info.reenterPassword){
    		$scope.clear = true;
    		$("#password").val("");
    		$("#reenterPassword").val("");
    		
    	}
    	else{
    		UserFactory.create(info)
    		.success(function(data) {
    			console.log(data);
    	        $window.sessionStorage.token = data;
    	        $scope.clear = false;
    			$scope.message = true;
    			$scope.msg = "User registered successfully..Now u can login";
    			$scope.info = {};
    			
    		})
    		.error(function (data, status, headers, config) {
        // Erase the token if the user fails to log in
        delete $window.sessionStorage.token;
        $scope.isAuthenticated = false;

        // Handle login errors here
        $scope.error = 'Error: Invalid user or password';
        $scope.welcome = '';
      });
    	}
    	
    	
    };
    $scope.log = function() {
    	var lo = $scope.login;
    	console.log(lo);
        
		
        UserFactory.loggedIn(lo)
        .success(function(ids){
             console.log(ids);  
             $window.location.href= "#/home/"+ids

        })
        .error(function(data){
        	
        });

    	
    	
    };
}]);
app.controller('MyCtrl2',['$scope', 'UserFactory','$location','$window','$routeParams', function ($scope, UserFactory,$location,$window,$routeParams) {
	         var Id = $routeParams.Id;
	         console.log(Id);
	         UserFactory.getHome(Id)
	         .success(function(user){
	        	 console.log(user);
	         })
	         .error(function(){
	        	 
	         });
}]);

