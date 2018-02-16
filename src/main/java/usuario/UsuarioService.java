package usuario;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import artista.Artista;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	public List<Usuario> getUsuarios() {
		return usuarioRepository.findAll();
	}

	public Usuario getUsuario(String id) {
		return usuarioRepository.findOne(id);
	}

	public void addUsuario(Usuario usuario) {
		usuarioRepository.save(usuario);
	}

	
}
