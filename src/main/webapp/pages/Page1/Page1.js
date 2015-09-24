Application.$controller("Page1PageController", ["$scope", function($scope) {
    "use strict";

    /* perform any action with the variables inside this block(on-page-load) */
    $scope.onPageVariablesReady = function() {
        /*
         * variables can be accessed through '$scope.Variables' property here
         * e.g. $scope.Variables.staticVariable1.getData()
         */
    };

    /* perform any action with widgets inside this block */
    $scope.onPageReady = function() {
        /*
         * widgets can be accessed through '$scope.Widgets' property here
         * e.g. $scope.Widgets.byId(), $scope.Widgets.byName()or access widgets by $scope.Widgets.widgetName
         */
    };


    $scope.button3Click = function($event, $isolateScope) {
        $scope.Variables.ID_NameValues.setInput('id', $scope.temp.id);
        $scope.Variables.ID_NameValues.setInput('name', $scope.temp.name);
        $scope.Variables.ID_NameValues.insertRecord();

    };


    $scope.button3Click1 = function($event, $isolateScope) {
        if ($scope.temp.id.length > 0) {
            $scope.temp.id = null;
        }

        if ($scope.temp.name.length > 0) {
            $scope.temp.name = '';
        }
    };

}]);