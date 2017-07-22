/**
 * Created by Srija on 7/19/2017.
 */
(function () {
    'use strict';
    
    angular.module('carTracker')
        .service('VehicleService', VehicleService);

    VehicleService.$inject = ['$q','$http'];

    function VehicleService($q,$http) {
        var self = this;

        self.getVehicles = function(){

           // var deferred = $q.defer()

           return $http.get('http://localhost:8088/api/vehicles')
                .then(function (response){
                    return response;
                   // deferred.resolve(response);
                }, function (error) {
                    return $q.reject(error);
                });

          //  return deferred.promise;
        };
    }
    
})();
