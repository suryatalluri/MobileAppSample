Application.$controller("MainPageController", ["$scope", function($scope) {
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





    $scope.LoginClick = function($event, $isolateScope) {
        if ($scope.temp.username == 'null' && $scope.temp.password == 'null') {
            alert("Enter valid credentials");
        } else {
            if ($scope.temp.switch == 'on') {
                $scope.Variables.loginVariable.setInput('username', $scope.temp.username);
                $scope.Variables.loginVariable.setInput('password', $scope.temp.password);
                $scope.Variables.loginVariable.insertRecord();
            } else {
                $scope.Variables.loginVariable.setInput('username', '');
                $scope.Variables.loginVariable.setInput('password', '');
            }
        }
    };




}]);