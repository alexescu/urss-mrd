
mrdControllers.controller('HeaderController',	['$scope', '$interval', '$state', '$http', function($scope, $interval, $state, $http) {

	/* View Parameters */
	$scope.roomId = 'A11'; 
	$scope.currentMeeting = {
			roomId : 'A11',
			start : '10:00',
			end : '11:00',
			subject : 'Winter is coming!',
			owner : 'John Snow'
		};	
	
	$scope.date = new Date();
	
	
	$scope.selectedColor = 'green';
	$scope.selectedButton = 'book-ad-hoc';
	$scope.bodyColor = {'background-color': '#099c35'};
		

	
	/*Timer*/	
	$interval(getRoom, 5000);	
	$interval(callUpdateTime, 1000);
	

	/* REST web-service consumers */
	function getRoom() {
		$http
		.get(
				'http://localhost/urss-mrd-app/rest/bookings/getLastBook')
				.success(function(data) {
					if (data) {
						$scope.currentMeeting.owner = data.reserver;
						$scope.currentMeeting.subject = data.subject;
					}					
				})
				.error(
						function(data, status) {
							$scope.currentMeeting = data
							|| "Request failed";
							$scope.status = status;
						});
	} ;
	
	
	/* Functions */
	function callUpdateTime() {
	   	$scope.date = new Date();
	}

}]);