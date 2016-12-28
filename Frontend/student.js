var studentController = angular.module('student', [])

  studentController.controller('studentController',  function($scope , $http) {
  $scope.student= {
  };
  $scope.delId=0;

    $scope.addStudent = function(){
    console.log($scope.student.name);
      console.log("in addStudent");
      $http.post('http://localhost:8080/students', $scope.student);
    }


$scope.deleteStudent=function(s1){
        $scope.student = s1;
        console.log("In Delete Student");

        $http.post('http://localhost:8080/students/delete',   $scope.student )
        .then(function(response){
          console.log($scope.student) ;
          console.log("success");
        },
        function(response){
          console.log("failure");
          console.log($scope.student);
        }
      );

}

      $http.get("http://localhost:8080/students")
        .then(function(response){
         $scope.students = response.data;
          console.log("peppa");
         console.log($scope.students[0].name);
        });
  });
