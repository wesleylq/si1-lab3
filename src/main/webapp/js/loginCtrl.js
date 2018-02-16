angular.module("sistema").controller("loginCtrl", function ($scope, $window, $http, $timeout, $rootScope) {
    $scope.app = "sistema";

    
    $scope.usuarios = [];
        
    carregarUsuarios = function () {
	   	$http.get("http://localhost:8080/usuarios").then(function(response) {
	           $scope.usuarios = response.data;
	        });
		};	
		
		contemUsuario = function (lista,email,senha) {
	        retorno = false
	        angular.forEach(lista, function (value,index) {
	        	
	            if(value.email === email && value.senha === senha){
	                retorno = true
	            }
	        });
	        return retorno
	    };
    
    $scope.adicionaUsuario = function (nome, email, senha) {
    	   	
        $http({ url: "http://localhost:8080/usuarios",
                method: "POST",
                data: {"id": nome, "nome": nome, "email": email, "senha":senha }
            });
        $window.location.href = "/index.html";
    	
        };
        
     $scope.login = function(email, senha){
    	    	 
    	 if(contemUsuario($scope.usuarios, email, senha) === true){
    		 $window.location.href = "/menu.html"; 
    	 };
    	 
     };
     
    
               	
    
    carregarUsuarios();
   
});

