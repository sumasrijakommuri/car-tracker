/**
 * Created by Srija on 7/20/2017.
 */

(function () {
    'use strict';

    angular.module("carTracker")
        .controller('AlertNumberController', AlertNumberController);

    AlertNumberController.$inject = ['AlertNumberService', '$scope', 'VehicleService'];

    function AlertNumberController(AlertNumberService, $scope,VehicleService ) {

        var alertnumVm = this;

        $scope.check = function () {
            console.log($scope.vinvalue);
            AlertNumberService.getAlertData($scope.vinvalue)
                .then(function (response) {
                    alertnumVm.alertList = response.data;
                    console.log(alertnumVm.alertList);
                }, function (error) {
                    console.log(error);
                });
        }


        AlertNumberService.getAlertNumbers()
            .then(function (response) {
                alertnumVm.alertnum = response.data;
                console.log(response.data);
            }, function (error) {
                console.log(error);
            });

        VehicleService.getVehicles()
            .then(function (response) {
                alertnumVm.vehicles = response.data;
            },function (error) {
                console.log(error);
            })

    }


})();

