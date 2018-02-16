package artista;


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
public class ArtistaController {
	
	@Autowired
	private ArtistaService artistaService;
	
	@RequestMapping("/artistas")
	public List<Artista> getArtistas() {
		return artistaService.getArtistas();
	}
	
	@RequestMapping("/artistas/{id}")
	public Artista getArtista(@PathVariable String id) {
		return artistaService.getArtista(id);
	}
		
    @RequestMapping(value = "/artistas", method = RequestMethod.POST)
    public void addArtista(@RequestBody Artista artista) {
    	artistaService.addArtista(artista);
    }
    
    @RequestMapping(value = "/artistas/{id}", method = RequestMethod.DELETE)
    public void deleteArtista(@PathVariable String id) {
    	artistaService.deleteArtista(id);
    }
    
    

}