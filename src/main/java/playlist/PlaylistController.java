package playlist;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("")
public class PlaylistController {
	
	@Autowired
	private PlaylistService playlistService;
	
	@RequestMapping("/playlists")
	public List<Playlist> getPlaylists() {
		return playlistService.getPlaylists();
	}
		
    @RequestMapping(value = "/playlists", method = RequestMethod.POST)
    public void addPlaylist(@RequestBody Playlist playlist) {
    	 playlistService.addPlaylist(playlist);
    }
    
    @RequestMapping(value = "/playlists/{id}", method = RequestMethod.DELETE)
    public void deletePlaylist(@PathVariable String id) {
    	playlistService.deletePlaylist(id);
    }
    

}