package musica;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MusicaRepository extends JpaRepository <Musica, String>{

	
	public List<Musica> findAllByArtistaId(String artistaId);
}
