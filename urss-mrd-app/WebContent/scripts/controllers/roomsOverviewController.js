/*
 * Controller for the RoomS Overview page! 
 * 
 */
mrdControllers.controller('RoomsOverviewController', function($scope, $interval, $state, $http) {

					/* Navigation */
					$scope.nextPage = function(page) {
						$state.go(page);
					};

					$scope.prevPage = function(page) {
						$state.go(page);
					};

					/* rooms-overview table component */
					$scope.rooms = [ 'A01', 'A06', 'A07', 'A08', 'A11', 'A21',
							'B11', 'B12' ];
					$scope.hours = [ '08:00', '09:00', '10:00', '11:00',
							'12:00', '13:00', '14:00', '15:00', '16:00',
							'17:00', '18:00', '19:00', '20:00' ];
					$scope.rowCollection1 = [ {
						room_id : 'A01',
						start : '08:00',
						end : '09:00',
						subject : 'Know how transfer',
						name : 'Cristina Muresan'
					}, {
						room_id : 'A11',
						start : '09:00',
						end : '10:00',
						subject : 'Know how transfer',
						name : 'Cristina Muresan'
					}, {
						room_id : 'A21',
						start : '10:00',
						end : '11:00',
						subject : 'Winter is coming!',
						name : 'John Snow'
					}, {
						room_id : 'B11',
						start : '11:00',
						end : '12:00',
						subject : '',
						name : ''
					}, {
						room_id : 'B12',
						start : '12:00',
						end : '13:00',
						subject : 'HR Interview',
						name : 'Daniela Onac'
					}, {
						room_id : 'A01',
						start : '13:00',
						end : '14:00',
						subject : '',
						name : ''
					}, {
						room_id : 'A01',
						start : '14:00',
						end : '15:00',
						subject : '',
						name : ''
					}, {
						room_id : 'A01',
						start : '15:00',
						end : '16:00',
						subject : '',
						name : ''
					}, {
						room_id : 'A01',
						start : '16:00',
						end : '17:00',
						subject : '',
						name : ''
					}, {
						room_id : 'A01',
						start : '18:00',
						end : '19:00',
						subject : '',
						name : ''
					}, {
						room_id : 'A01',
						start : '19:00',
						end : '20:00',
						subject : '',
						name : ''
					}, {
						room_id : 'A01',
						start : '19:00',
						end : '20:00',
						subject : '',
						name : ''
					}, {
						room_id : 'A01',
						start : '19:00',
						end : '20:00',
						subject : '',
						name : ''
					} ];

					$scope.result = getSchedule();

					function getSchedule() {
						var aux = [ {
							h : '08:00',
							name : [ '', '', '', '', '', '', '', '' ]
						}, {
							h : '09:00',
							name : [ '', '', '', '', '', '', '', '' ]
						}, {
							h : '10:00',
							name : [ '', '', '', '', '', '', '', '' ]
						}, {
							h : '11:00',
							name : [ '', '', '', '', '', '', '', '' ]
						}, {
							h : '12:00',
							name : [ '', '', '', '', '', '', '', '' ]
						}, {
							h : '13:00',
							name : [ '', '', '', '', '', '', '', '' ]
						}, {
							h : '14:00',
							name : [ '', '', '', '', '', '', '', '' ]
						}, {
							h : '15:00',
							name : [ '', '', '', '', '', '', '', '' ]
						}, {
							h : '16:00',
							name : [ '', '', '', '', '', '', '', '' ]
						}, {
							h : '17:00',
							name : [ '', '', '', '', '', '', '', '' ]
						}, {
							h : '18:00',
							name : [ '', '', '', '', '', '', '', '' ]
						}, {
							h : '19:00',
							name : [ '', '', '', '', '', '', '', '' ]
						}, {
							h : '20:00',
							name : [ '', '', '', '', '', '', '', '' ]
						} ];
						for (var i = 0; i < $scope.hours.length; i++) {
							for (var j = 0; j < $scope.rooms.length; j++) {
								for (var k = 0; k < $scope.rowCollection1.length; k++) {
									if ($scope.rowCollection1[k].room_id == $scope.rooms[j]
											&& ($scope.rowCollection1[k].start == $scope.hours[i] || $scope.rowCollection1[k].end == $scope.hours[i])) {
										aux[i].name[j] = $scope.rowCollection1[k].subject;
									}
								}
							}
						}
						return aux;
					}

				});