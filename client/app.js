/**
 * Created by Srija on 7/18/2017.
 */

(function () {
    'use strict';

    angular.module('carTracker',['ngRoute']);

    angular.module('carTracker')
        .config(moduleConfig);

    moduleConfig.$inject = ['$routeProvider'];
    function moduleConfig($routeProvider) {
        $routeProvider
            .when('/vehicles',{
                templateUrl: "vehicle_details/vehicle.template.html"
            })
            .when('/alerts/:id', {
                templateUrl: "vehicle_alerts/alertdata.template.html"
            })
            .when('/alertsnumber',{
                templateUrl: "vehicle_alerts/alertnumber.template.html"
            })
            .otherwise({redirectTo:'/vehicles'});
    }


})();