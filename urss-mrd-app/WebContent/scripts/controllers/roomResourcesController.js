/*
 * Controller for the Room Resources page! 
 * 
 */

mrdControllers.controller('RoomResourcesController', function($scope,$interval, $state, $http) {
			/* Navigation */
			$scope.nextPage = function(page) {
				$state.go(page);
			};
		
			$scope.prevPage = function(page) {
				$state.go(page);
			};
		
			$scope.room = [ {
				"name" : "A11",
				"location" : "Uniqa building, second floor",
				"capacity" : "10",
				"resources" : [ {
					"name" : "Telco",
					"image" : "phone.png",
					"description" : "0361-771-426"
				}, {
					"name" : "Laptop charger",
					"image" : "charger.png",
					"description" : 1
				}, {
					"name" : "Internet ports",
					"image" : "ports.png",
					"description" : 3
				}, {
					"name" : "WiFi",
					"image" : "wifi.png",
					"description" : ""
				}, {
					"name" : "Wide screen",
					"image" : "screen.png",
					"description" : 1
				}, {
					"name" : "Video conference system",
					"image" : "video.png",
					"description" : 1
				} ]
			}, {
				"name" : "A12",
				"location" : "Uniqa building, second floor",
				"capacity" : "10",
				"resources" : [ {
					"name" : "Telco",
					"image" : "phone.png",
					"description" : "0361-771-426"
				}, {
					"name" : "Laptop charger",
					"image" : "charger.png",
					"description" : 2
				}, {
					"name" : "Internet ports",
					"image" : "ports.png",
					"description" : 4
				}, {
					"name" : "WiFi",
					"image" : "wifi.png",
					"description" : ""
				}, {
					"name" : "Wide screen",
					"image" : "screen.png",
					"description" : 1
				} ]
			}
		
			];
		
		}
);