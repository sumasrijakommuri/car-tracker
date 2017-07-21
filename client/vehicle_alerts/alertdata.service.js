/**
 * Created by Srija on 7/20/2017.
 */
(function () {
    'use strict';

    angular.module('carTracker')
        .service('AlertDataService', AlertDataService);

    AlertDataService.$inject = ['$q','$http'];

    function AlertDataService($q,$http) {
        var self = this;

        self.getAlertData = function(){


            return $http.get('http://localhost:8088/api/vehiclealerts/')
                .then(function (response){
                    return response;

                }, function (error) {
                    return $q.reject(error);
                });
        };
    }
});