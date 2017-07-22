/**
 * Created by Srija on 7/20/2017.
 */

(function () {
    'use strict';

    angular.module("carTracker")
        .controller('AlertNumberController',AlertNumberController);

    AlertNumberController.$inject =['AlertNumberService','$scope', '$window'];

    function AlertNumberController(AlertNumberService,$scope, $window) {

        var alertnumVm = this;
        //alertnumVm.vin ='1HGCR2F3XFA027534';
        //alertnumVm.vin = $scope.vinvalue;
        //console.log(vinvalue);

        document.addEventListener(document, "touchstart", function(e) {
            console.log(e.defaultPrevented);  // will be false
            e.preventDefault();   // does nothing since the listener is passive
            console.log(e.defaultPrevented);  // still false
        }, {passive: true});

        alertnumVm.alertList = [];

        $scope.getVinValue = function (param) {
            console.log(param);
            AlertNumberService.getAlertData(param)
                .then(function (response) {
                    //alertnumVm.alertList = response.data;
                    alertnumVm.alertList = alertnumVm.alertList.concat(alertnumVm.alertList, response.data);
                    console.log(alertnumVm.alertList);
                },function (error) {
                    console.log(error);
                });
        };

        AlertNumberService.getAlertNumbers()
            .then(function (response) {
                alertnumVm.alertnum = response.data;
                console.log(response.data);
            },function (error) {
                console.log(error);
            });



    }

})();
