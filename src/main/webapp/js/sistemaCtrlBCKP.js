angular.module("sistema").controller("sistemaCtrl", function ($scope, $window, $http) {
    $scope.app = "sistema";

    $scope.artistas = [];
    $scope.playlists = [];
    
    carregarPlaylists = function () {
    	$http.get("http://localhost:8080/playlists").then(function(response) {
            $scope.playlists = response.data;
        });
	};
	
	carregarPlaylists();
	
    contemElemento = function (lista,nome) {
        retorno = false
        angular.forEach(lista, function (value,index) {
            if(value.nome === nome){
                retorno = true
            }
        });
        return retorno
    };

    $scope.adicionaArtista = function (artistaNome) {

        var artista = {
            nome: artistaNome,
            albuns : []
        };

        if($scope.artistas.length === 0 || contemElemento($scope.artistas,artistaNome) === false){
            $scope.artistas.push(artista);
        }else{
            window.alert("Artista já adicionado!")
        }
    };


    $scope.adicionaAlbum = function (artistaNome,albumNome,musica) {

        var album = {nome: albumNome , musicas: []} ;

        if(contemElemento($scope.artistas,artistaNome) === false){
            window.alert("Artista Inexistente");
        }

        angular.forEach($scope.artistas, function (value,index) {
            if(value.nome === artistaNome){
                if(value.albuns.length===0 || contemElemento(value.albuns,albumNome)===false){
                    value.albuns.push(album);
                }
                adicionaMusica(value.albuns,albumNome,musica);
            }
        });
    };

    adicionaMusica = function (albuns,albumNome,musica) {
        angular.forEach(albuns, function (value,index) {
            if(value.nome === albumNome){
                if(contemElemento(value.musicas,musica.nome)===false){
                    value.musicas.push(angular.copy(musica));
                    delete $scope.musica;
                }else{
                    window.alert("musica ja está no album")
                }
            }
        });
    };


    $scope.adicionaPlayList = function (playlistNome) {

        playlist = {nome: playlistNome, musicas: []};
        
        if($scope.playlists.length===0 || contemElemento($scope.playlists,playlistNome) === false){
            $scope.playlists.push(playlist);
            $http.post("http://localhost:8080/playlists", playlist.success(function (response) {
			carregarPlaylists();					
			});

        }else{
            window.alert("PlayList já existente");
        }
       
    };

    $scope.adicionaMusicaPlayList = function (playlistNome,artistaNome,musicaNome) {

        musica = {artista: artistaNome, nome: musicaNome}

        if(contemElemento($scope.artistas,artistaNome) === false){
            window.alert("Artista nao existente no sistema")
        }

        if(contemElemento($scope.playlists,playlistNome) === false){
            window.alert("PlayList nao existente no sistema")
        }

        musicaNaoExistente = false
        angular.forEach($scope.artistas, function (value,index) {
            if(value.nome === artistaNome){
                angular.forEach(value.albuns, function (value,index) {
                    if(contemElemento(value.musicas,musicaNome)===false){
                        musicaNaoExistente = true;
                    }
                });
            }
        });

        angular.forEach($scope.playlists, function (value,index) {
            if(value.nome === playlistNome){
                if(contemElemento(value.musicas,musicaNome)===false){
                    value.musicas.push(musica);
                }else{
                    window.alert("Musica já adicionada na PlayList")
                }
            };
        });
    };

    $scope.excluiPlayList = function (playlist) {
        if (confirm("Deseja realmente excluir?") == true) {
            removeIndex = $scope.playlists.indexOf(playlist)
            delete $scope.playlists[removeIndex]
        }



    }

    $scope.excluiMusica = function (playlist, musica) {

        if (confirm("Deseja realmente excluir?") == true) {
            playlistIndex = $scope.playlists.indexOf(playlist)

            removeIndex = $scope.playlists[playlistIndex].musicas.indexOf(musica)

            delete $scope.playlists[playlistIndex].musicas[removeIndex]
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
    
   
});

