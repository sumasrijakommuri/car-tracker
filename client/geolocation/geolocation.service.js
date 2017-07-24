
(function () {
    'use strict';

    angular.module('carTracker')
        .service('GeoLocationService', GeoLocationService);

    GeoLocationService.$inject = ['$q','$http'];

    function GeoLocationService($q,$http) {
        var self = this;

        self.getLocation = function(id){

            return $http.get('http://localhost:8088/api/readings/'+id)
                .then(function (response){
                    return response;
                }, function (error) {
                    return $q.reject(error);
                });
        };
    }

})();
