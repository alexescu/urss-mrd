/*
 * Controller for the Welcome page! 
 * 
 */

mrdControllers.controller('WelcomeController', [ '$scope', '$interval', '$state', '$http', function($scope, $interval, $state, $http) {
	
	/* Navigation */
	$scope.nextPage = function(page) {
		$state.go(page);
	};

	$scope.prevPage = function(page) {
		$state.go(page);
	};
	
	
}]);