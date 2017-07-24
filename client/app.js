/**
 * Created by Srija on 7/18/2017.
 */

(function () {
    'use strict';

    angular.module('carTracker', ['ngRoute','uiGmapgoogle-maps']);

    angular.module('carTracker')
        .config(moduleConfig);

    moduleConfig.$inject = ['$routeProvider'];
    function moduleConfig($routeProvider) {
        $routeProvider
            .when('/vehicles', {
                templateUrl: "vehicle_details/vehicle.template.html"
            })
            .when('/alerts', {
                templateUrl: "vehicle_alerts/alertdata.template.html"
            })
            .when('/alertsnumber', {
                templateUrl: "vehicle_alerts/alertnumber.template.html"
            })
            .when('/historyplots', {
                templateUrl: "history_plots/historyplot.template.html"
            })
            .when('/geolocation',{
                templateUrl: "geolocation/geolocation.template.html"
            })
            .otherwise({redirectTo: '/vehicles'});
    }


})();