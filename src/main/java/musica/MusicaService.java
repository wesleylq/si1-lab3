package musica;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class MusicaService {
	@Autowired
	private MusicaRepository musicaRepository;
	/*
	@Autowired
	private MusicaPlaylistRepository musicaPlaylistRepository;*/
		
	public List<Musica> getMusicas(String artistaId) {
		return musicaRepository.findAllByArtistaId(artistaId);
	}
	
	public Musica getMusica(String id) {
		return musicaRepository.findOne(id);
	}

	public void addMusica(Musica musica) {
		musicaRepository.save(musica);
		
	}
	//
		/*
	public List<Musica> getMusicasPlaylist(String playlistId) {
		return musicaPlaylistRepository.findAllByPlaylistId(playlistId);
	}
	
	public Musica getMusicaPlaylist(String id) {
		return musicaPlaylistRepository.findOne(id);
	}

	public void addMusicaPlaylist(Musica musica) {
		musicaPlaylistRepository.save(musica);
		
	}*/
	
}
