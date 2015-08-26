/*
 * Controller for the Room Overview page! 
 * 
 */

mrdControllers.controller('RoomOverviewController', ['$scope', '$interval', '$state', '$http', function($scope, $interval, $state, $http) {

			 /* Navigation */
			 $scope.nextPage = function(page) {
				 $state.go(page);
			 };

			 $scope.prevPage = function(page) {
				 $state.go(page);
			 };
			
			 $scope.rowCollection = [ {
				 from_hour : '08:00',
				 to_hour : '09:00',
				 meeting_name : 'Know how transfer',
				 organizer_name : 'Cristina Muresan'
			 }, {
				 from_hour : '09:00',
				 to_hour : '10:00',
				 meeting_name : 'Know how transfer',
				 organizer_name : 'Cristina Muresan'
			 }, {
				 from_hour : '10:00',
				 to_hour : '11:00',
				 meeting_name : 'UDM Sprint Planning',
				 organizer_name : 'Ioana Apintei'
			 }, {
				 from_hour : '11:00',
				 to_hour : '12:00',
				 meeting_name : 'Know how transfer',
				 organizer_name : 'Cristina Muresan'
			 }, {
				 from_hour : '12:00',
				 to_hour : '13:00',
				 meeting_name : 'HR Interview',
				 organizer_name : 'Daniela Onac'
			 }, {
				 from_hour : '13:00',
				 to_hour : '14:00',
				 meeting_name : 'UDM Sprint Planning',
				 organizer_name : 'Ioana Apintei'
			 }, {
				 from_hour : '14:00',
				 to_hour : '15:00',
				 meeting_name : 'UDM Sprint Planning',
				 organizer_name : 'Ioana Apintei'
			 }, {
				 from_hour : '15:00',
				 to_hour : '16:00',
				 meeting_name : 'HR Interview',
				 organizer_name : 'Daniela Onac'
			 }, {
				 from_hour : '16:00',
				 to_hour : '17:00',
				 meeting_name : 'HR Interview',
				 organizer_name : 'Daniela Onac'
			 }, {
				 from_hour : '17:00',
				 to_hour : '18:00',
				 meeting_name : 'HR Interview',
				 organizer_name : 'Daniela Onac'
			 }, {
				 from_hour : '18:00',
				 to_hour : '19:00',
				 meeting_name : 'Know how transfer',
				 organizer_name : 'Cristina Muresan'
			 }, {
				 from_hour : '19:00',
				 to_hour : '20:00',
				 meeting_name : 'HR Interview',
				 organizer_name : 'Daniela Onac'
			 } ];

		 } ]);