/**
 * Created by Srija on 7/22/2017.
 */
(function () {
    'use strict';

    angular.module('carTracker')
        .service('HistoryPlotService',HistoryPlotService)

    HistoryPlotService.$inject =['$http','$q'];
    function HistoryPlotService($http,$q) {
        
        var self = this;
        
        self.getHistory = function (vinid,signal) {

            return $http.get("http://localhost:8088/api/readings/"+ vinid+ "/"+signal)
                .then(function (response) {
                    return response;
                },function (error) {
                    return $q.reject(error);
                })

        }

    }
})();