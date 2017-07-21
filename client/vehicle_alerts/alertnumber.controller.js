/**
 * Created by Srija on 7/20/2017.
 */

(function () {
    'use strict';

    angular.module("carTracker")
        .controller('AlertNumberController',AlertNumberController);

    AlertNumberController.$inject =['AlertNumberService'];
    function AlertNumberController(AlertNumberService) {

        var alertnumVm = this;

        AlertNumberService.getAlertNumbers()
            .then(function (response) {
                alertnumVm.alertnum = response.data;
                console.log(response.data);
            },function (error) {
                console.log(error);
            });

    }

});
