/**
 * Created by Srija on 7/20/2017.
 */
/**
 * Created by Srija on 7/19/2017.
 */
(function () {
    'use strict';

    angular.module('carTracker')
        .service('AlertNumberService', AlertNumberService);

    AlertNumberService.$inject = ['$q','$http'];

    function AlertNumberService($q,$http) {
        var self = this;

        self.getAlertNumbers= function(){

            return $http.get('http://localhost:8088/api/alertnumbers')
                .then(function (response){
                    return response;

                }, function (error) {
                    return $q.reject(error);
                });

        };
    }

})();

