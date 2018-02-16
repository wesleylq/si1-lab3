package artista;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArtistaService {
	@Autowired
	private ArtistaRepository artistarepository;
		
	public List<Artista> getArtistas() {
		return artistarepository.findAll();
	}
	
	public Artista getArtista(String id) {
		return artistarepository.findOne(id);
	}
	

	public void addArtista(Artista artista) {
		artistarepository.save(artista);
		
	}
	
	public void deleteArtista(String artistaId) {
		artistarepository.delete(artistaId);
	}

	
		

}
