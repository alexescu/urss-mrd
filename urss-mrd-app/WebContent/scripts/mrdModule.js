/* Important -  this JS must be loaded before the controller js */

var mrdApp = angular.module('mrdApp', ['ui.router', 'ngTouch', 'mrdControllers']); 

mrdApp.config(function($stateProvider, $urlRouterProvider) {
    
    $urlRouterProvider.otherwise('welcome');
    
    $stateProvider        
        
        .state('welcome', {
            url: '/welcome',
            controller: 'WelcomeController',
            templateUrl: 'pages/welcome.html'
        })
        
		 .state('rooms_overview', {                  
			url: '/rooms_overview',
			controller: 'RoomsOverviewController',
            templateUrl: 'pages/rooms_overview.html'
        })
		
		  .state('room_overview', {                  
			url: '/room_overview',
			controller: 'RoomOverviewController',
            templateUrl: 'pages/room_overview.html'
        })
		
		 .state('resource_overview', {                  
			url: '/resource_overview',
			controller: 'RoomResourcesController',
            templateUrl: 'pages/resource_overview.html'
        });
        
});