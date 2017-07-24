(function () {
    'use strict';

    angular.module('carTracker')
        .controller('GeoLocationController', GeoLocationController);

    GeoLocationController.$inject = ['GeoLocationService', 'VehicleService', '$scope'];
    function GeoLocationController(GeoLocationService, VehicleService, $scope) {
        var geoLocationVm = this;
        geoLocationVm.locations = [];

        VehicleService.getVehicles()
            .then(function (response) {
                geoLocationVm.vehicles = response.data;
                console.log(response.data);
            }, function (error) {
                console.log(error);
            });

        $scope.check = function () {
            GeoLocationService.getLocation($scope.vinvalue)
                .then(function (response) {
                    geoLocationVm.locations = response.data;
                    console.log($scope.vinvalue);
                    // console.log(response);var locations = geoLocationVm.locations;
                    window.map = new google.maps.Map(document.getElementById('map'), {
                        mapTypeId: google.maps.MapTypeId.ROADMAP,
                        scrollwheel: false
                    });
                    console.log("In Map");
                    console.log(locations);
                    var infowindow = new google.maps.InfoWindow();
                    var flightPlanCoordinates = [];
                    var bounds = new google.maps.LatLngBounds();

                    console.log("reached before for")
                    for (var i = 0; i < locations.length; i++) {
                        var marker = new google.maps.Marker({
                            position: new google.maps.LatLng(locations[i][0], locations[i][1]),
                            map: map
                        });
                        flightPlanCoordinates.push(marker.getPosition());
                        bounds.extend(marker.position);

                        google.maps.event.addListener(marker, 'click', (function (marker, i) {
                            return function () {
                                // infowindow.setContent(locations[i]['title']);
                                infowindow.open(map, marker);
                            }
                        })(marker, i));
                    }
                    console.log("reached after for");
                    console.log(flightPlanCoordinates);

                    map.fitBounds(bounds);

                    var flightPath = new google.maps.Polyline({
                        map: map,
                        path: flightPlanCoordinates,
                        strokeColor: "#FF0000",
                        strokeOpacity: 1.0,
                        strokeWeight: 2
                    });




                }, function (error) {
                    console.log(error);
                });


        }

       // google.maps.event.addDomListener(window, 'load', initialize);


        //$scope.map = { center: { latitude: 45, longitude: -73 }, zoom: 8 };

            //setTimeout(initialize(),500);
            // $(document).ready(function () {
            //     initialize();
            // });
        }

        // function initialize() {
        //
        //     // if (jQuery('#map').length > 0) {
        //

    }
)();
