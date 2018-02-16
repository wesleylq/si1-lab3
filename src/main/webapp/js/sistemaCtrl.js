angular.module("sistema").controller("sistemaCtrl", function ($scope, $window, $http, $timeout, $rootScope) {
    $scope.app = "sistema";

    $scope.artistas = [];
    $scope.playlists = [];
      
    
    carregarPlaylists = function () {
    	$http.get("http://localhost:8080/playlists").then(function(response) {
            $scope.playlists = response.data;
        });
	};
	
	 carregarArtistas = function () {
	    	$http.get("http://localhost:8080/artistas").then(function(response) {
	            $scope.artistas = response.data;
	        });
		};
		
	
	
	
    
	$scope.adicionaPlayList = function (playlistNome) {
    	
    $http({ url: "http://localhost:8080/playlists",
            method: "POST",
            data: {"id": playlistNome, "nome": playlistNome}
        }); 
	
    };
    
    
    $scope.excluiPlayList = function (playlist) {
    	 
    $http({ url: "http://localhost:8080/playlists/" + playlist.nome,
            method: "DELETE",
         });
      
    };
    
    
    $scope.adicionaArtista = function (artistaNome) {
        
        $http({ url: "http://localhost:8080/artistas",
            method: "POST",
            data: {"id": artistaNome, "nome": artistaNome}
        }); 
               
    };
        
    $scope.excluiArtista = function (artista) {
   	 
        $http({ url: "http://localhost:8080/artistas/" + artista.nome,
                method: "DELETE",
             });
          
        };
        
    $scope.adicionaMusica = function (musica, album, artista) {
        	
    	$http({ url: "http://localhost:8080/artistas/" + artista + "/musicas" ,
                method: "POST",
                data: {"id": musica, "nome": musica, "album": album}
                }); 
        	
    };

    $scope.adicionaMusicaPlayList = function (playlist,artista,musica) {
    	
    	$http.get("http://localhost:8080/artistas/" + artista + "/musicas/" + musica ).then(function (response) {
    		
    		$http({ url: "http://localhost:8080/playlists/" + playlist + "/musicas" ,
                method: "POST",
                data: {"id":response.data["id"], "nome":response.data["nome"], "album":response.data["album"], "artista":artista}
                }); 
		});
    	
    
    };
    
    $scope.mostraArtistaInfo = function (artista) {
        $scope.artistaInfo = artista;
        $scope.varMostraArtista = true;

    };

    $scope.mostraPlayListInfo = function (playlist) {
        $scope.playlistInfo = playlist;
        $scope.varMostraPlayList = true;

    };

   
    carregarPlaylists();
    carregarArtistas();
});

