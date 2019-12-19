var cartApp = angular.module('cartApp', []);
 
cartApp.controller('cartCtrl',  function ($scope, $http) {
	
	$scope.refreshCart = function(cartId) {
		  						$http.get('/webstorejpa/rest/cart/'+$scope.cartId)
		  						 	 .success(function(data) {
		  						 		 		$scope.cart = data;
		  						 	 		});
		  					};
		  					
//	$scope.clearCart = function() {
//		  						$http.delete('/webstorejpa/rest/cart/'+$scope.cartId)
//		  							 .success($scope.refreshCart($scope.cartId));
		  						
//	  					  };
	  					  
	$scope.initCartId = function(cartId) {
		  					$scope.cartId=cartId;
		  					$scope.refreshCart($scope.cartId);
	  						};
	  						
	  $scope.addToCart = function(productId) {
		  						$http.put('/webstorejpa/rest/cart/add/'+productId)
		  						 	 .success(function(data) {
		  						 		 		$scope.refreshCart($http.get('/webstorejpa/cart'));
		  						 		 		alert("Product Successfully added to the Cart!");
		  						 	 		});
		  					};
	  $scope.removeFromCart = function(productId) {
			  						$http.put('/webstorejpa/rest/cart/remove/'+productId)
			  						 	 .success(function(data) {
			  						 		 	$scope.refreshCart($http.get('/webstorejpa/cart' ));
			  						 	 		});
			  					};
	  });
