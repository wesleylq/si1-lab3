package musica;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import artista.Artista;
import playlist.Playlist;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("")
public class MusicaController {
	
	@Autowired
	private MusicaService musicaService;
	
	//>>>artista<<<
	@RequestMapping("/artistas/{artistaId}/musicas")
	public List<Musica> getMusicas(@PathVariable String artistaId) {
		return musicaService.getMusicas(artistaId);
	}
	
	@RequestMapping("/artistas/{artistaId}/musicas/{id}")
	public Musica getMusica(@PathVariable String id, @PathVariable String artistaId){
		return musicaService.getMusica(id);
	}
		
    @RequestMapping(value = "/artistas/{artistaId}/musicas", method = RequestMethod.POST)
    public void addMusica(@RequestBody Musica musica, @PathVariable String artistaId) {
    	musica.setArtista(new Artista(artistaId, artistaId));
    	musicaService.addMusica(musica);
    }
        
    //>>>playlist<<<
    /*
    @RequestMapping(value = "/playlists/{playlistId}/musicas")
    public void addMusicaPlaylist(@RequestBody Musica musica, @PathVariable String playlistId) {
    	
    	//musica.setArtista(new Artista(musica.getArtista().getNome(), musica.getArtista().getNome()));
    	musica.setPlaylist(new Playlist(playlistId, playlistId));
    	
    	musicaService.addMusicaPlaylist(musica);
    }
    
    @RequestMapping("/playlists/{playlistId}/musicas/{id}")
	public Musica getMusicaPlaylist(@PathVariable String id, @PathVariable String playlistId){
		return musicaService.getMusicaPlaylist(id);
	}
    */
    
    
    
    
    
    
    
    
    /*
    @RequestMapping(value = "{artistaId}/musicas/{id}", method = RequestMethod.DELETE)
    public void deletePlaylist(@PathVariable String id, @PathVariable String artistaId) {
    	musicaService.deleteMusica(id);
    }*/


}