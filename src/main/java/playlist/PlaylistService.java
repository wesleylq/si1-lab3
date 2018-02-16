package playlist;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import musica.Musica;

@Service
public class PlaylistService {
	@Autowired
	private PlaylistRepository playlistrepository;
		
	public List<Playlist> getPlaylists() {
		return playlistrepository.findAll();
	}

	public void addPlaylist(Playlist playlist) {
		playlistrepository.save(playlist);
		
	}
	
	public void deletePlaylist(String id) {
		playlistrepository.delete(id);
	}

	

}
