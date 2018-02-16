package musicaPL;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MusicaPLService {
	@Autowired
	private MusicaPLRepository musicaRepository;
	
	
	//
		
	public List<MusicaPL> getMusicasPlaylist(String playlistId) {
		return musicaRepository.findAllByPlaylistId(playlistId);
	}
	
	public MusicaPL getMusicaPlaylist(String id) {
		return musicaRepository.findOne(id);
	}

	public void addMusicaPlaylist(MusicaPL musica) {
		musicaRepository.save(musica);
				
	}

	public void deleteMusica(String id) {
		musicaRepository.delete(id);
		
	}
	
}
