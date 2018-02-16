package artista;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import usuario.Usuario;

@Repository
public interface ArtistaRepository extends JpaRepository <Artista, String>{
		

}
