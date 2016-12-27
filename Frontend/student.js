var studentController = angular.module('student', [])

  studentController.controller('studentController', function($scope , $http) {

        $scope.message = "Nipun";

        $http.get("http://localhost:8080/students")
        .then(function(response){
         $scope.students = response.data;
          console.log("peppa");
         console.log($scope.students[0].name);
        });

  });