/**
 * Created by Srija on 7/19/2017.
 */

(function () {
    'use strict';

    angular.module('carTracker')
        .controller('VehicleController',VehicleController);

    VehicleController.$inject = ['VehicleService'];
    function VehicleController(VehicleService) {
        var vehicleVm = this;

        VehicleService.getVehicles()
            .then(function (response) {
                vehicleVm.vehicles = response.data;
                console.log(response.data);
            }, function (error) {
                console.log(error);
            });
    }
})();
