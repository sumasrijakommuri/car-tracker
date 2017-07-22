
(function () {
    'use strict';

    angular.module('carTracker')
        .service('AlertNumberService', AlertNumberService);

    AlertNumberService.$inject = ['$q','$http'];

    function AlertNumberService($q,$http) {


       function getAlertNumbers(){

            return $http.get('http://localhost:8088/api/alertnumbers')
                .then(function (response){
                    console.log(response);
                    return response;

                }, function (error) {
                    return $q.reject(error);
                });

        }

        function getAlertData(vinid) {

            return $http.get('http://localhost:8088/api/vehiclealerts/'+vinid).then(function (response) {

                    console.log(response);
                    return response;
                }, function (error) {
                    return $q.reject(error);
                });

        }

        return {
            getAlertNumbers :  getAlertNumbers,
            getAlertData : getAlertData
        }

    }

})();

