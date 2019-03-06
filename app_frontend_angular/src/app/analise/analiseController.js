$scope.sortField = undefined;
$scope.reverse = false;

$scope.isSortUp = function(fieldName){
   return $scope.sortField === fieldName && !$scope.reverse;
};
$scope.isSortDown = function(fieldName){
   return $scope.sortField === fieldName && $scope.reverse;
};
//order data
$scope.sort = function(fieldName){
   if ($scope.sortField === fieldName) {
       $scope.reverse = !$scope.reverse;
   }else{
       $scope.sortField = fieldName;
       $scope.reverse = false;

   };
}