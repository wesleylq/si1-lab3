package musicaPL;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MusicaPLRepository extends JpaRepository <MusicaPL, String>{

	
	public List<MusicaPL> findAllByPlaylistId(String playlistId);
}
