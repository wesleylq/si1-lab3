angular.module("sistema").controller("sistemaCtrl", function ($scope, $window, $http, $timeout, $rootScope) {
    $scope.app = "sistema";

    $scope.artistas = [];
    $scope.playlists = [];
      
    
    carregarPlaylists = function () {
    	$http.get("https://dashboard.heroku.com/playlists").then(function(response) {
            $scope.playlists = response.data;
        });
	};
	
	 carregarArtistas = function () {
	    	$http.get("https://dashboard.heroku.com/artistas").then(function(response) {
	            $scope.artistas = response.data;
	        });
		};
		
	
	
	
    
	$scope.adicionaPlayList = function (playlistNome) {
    	
    $http({ url: "https://dashboard.heroku.com/playlists",
            method: "POST",
            data: {"id": playlistNome, "nome": playlistNome}
        }); 
	
    };
    
    
    $scope.excluiPlayList = function (playlist) {
    	    
    if (confirm("Deseja realmente excluir?") == true){
    	 $http({ url: "https://dashboard.heroku.com/playlists/" + playlist.nome,
             method: "DELETE",
          });	
    }	 
   
      
    };
    
    
    $scope.adicionaArtista = function (artistaNome) {
        
        $http({ url: "https://dashboard.heroku.com/artistas",
            method: "POST",
            data: {"id": artistaNome, "nome": artistaNome}
        }); 
               
    };
        
    $scope.excluiArtista = function (artista) {
   	 
        $http({ url: "https://dashboard.heroku.com/artistas/" + artista.nome,
                method: "DELETE",
             });
          
        };
        
    $scope.adicionaMusica = function (musica, album, artista) {
        	
    	$http({ url: "https://dashboard.heroku.com/artistas/" + artista + "/musicas" ,
                method: "POST",
                data: {"id": musica, "nome": musica, "album": album}
                }); 
        	
    };

    $scope.adicionaMusicaPlayList = function (playlist,artista,musica) {
    	
    	$http.get("https://dashboard.heroku.com/artistas/" + artista + "/musicas/" + musica ).then(function (response) {
    		
    		$http({ url: "http://localhost:8080/playlists/" + playlist + "/musicas" ,
                method: "POST",
                data: {"id":response.data["id"], "nome":response.data["nome"], "album":response.data["album"], "artista":artista}
                }); 
		});
    	
    
    };
    
    $scope.excluiMusica = function (playlist, musica) {

        if (confirm("Deseja realmente excluir?") == true) {
        	$http({ url: "https://dashboard.heroku.com/playlists/" + playlist.nome + "/musicas/" + musica.nome,
                method: "DELETE",
             });
        }
    }
    
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

