package usuario;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import artista.Artista;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("")
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@RequestMapping("/usuarios")
	public List<Usuario> getUsuarios() {
		return usuarioService.getUsuarios();
	}
	
	@RequestMapping("/usuarios/{id}")
	public Usuario getUsuario(@PathVariable String id) {
		return usuarioService.getUsuario(id);
	}
	
	@RequestMapping(value = "/usuarios", method = RequestMethod.POST)
    public void addUsuario(@RequestBody Usuario usuario) {
    	usuarioService.addUsuario(usuario);
    }

}
