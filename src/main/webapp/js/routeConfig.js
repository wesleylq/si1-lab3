angular.module("sistema").config(function ($routeProvider) {
    $routeProvider.when("/criarPlaylist",{
        templateUrl: "template/criarPlaylist.html",
        controller: "sistemaCtrl"
    });

    $routeProvider.when("/verPlaylist",{
        templateUrl: "template/verPlaylist.html",
        controller: "sistemaCtrl"
    });

    $routeProvider.when("/pesquisar",{
        templateUrl: "template/pesquisa.html",
        controller: "sistemaCtrl"
    });

    $routeProvider.when("/addArtista",{
        templateUrl: "template/addArtista.html",
        controller: "sistemaCtrl"
    });

    $routeProvider.when("/addMusica",{
        templateUrl: "template/addMusica.html",
        controller: "sistemaCtrl"
    });
    
       
    $routeProvider.when("/registro",{
        templateUrl: "template/registro.html",
        controller: "loginCtrl"
    });
   
    
    $routeProvider.when("/login",{
        templateUrl: "template/login.html",
        controller: "loginCtrl"
    });
    
    
    
});