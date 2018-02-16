package musicaPL;


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
public class MusicaPLController {
	
	@Autowired
	private MusicaPLService musicaPLService;
	
	    
    @RequestMapping(value = "/playlists/{playlistId}/musicas", method = RequestMethod.POST)
    public void addMusicaPlaylist(@RequestBody MusicaPL musica, @PathVariable String playlistId) {
    	
    	musica.setPlaylist(new Playlist(playlistId, playlistId));
    	
    	musicaPLService.addMusicaPlaylist(musica);
    }
    
    @RequestMapping("/playlists/{playlistId}/musicas/{id}")
	public MusicaPL getMusicaPlaylist(@PathVariable String id, @PathVariable String playlistId){
		return musicaPLService.getMusicaPlaylist(id);
	}
    
    
    @RequestMapping(value = "/playlists/{playlistId}/musicas/{id}", method = RequestMethod.DELETE)
    public void deleteMusica(@PathVariable String id, @PathVariable String playlistId) {
    	musicaPLService.deleteMusica(id);
    }


}