 package playlist;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import artista.Artista;
import musicaPL.MusicaPL;
import usuario.Usuario;

@Entity
public class Playlist {
	
	@Id
	private String id;
	private String nome;
	/*
	@JsonBackReference (value = "usuario") 
	@ManyToOne
	private Usuario usuario;*/
	
	@JsonManagedReference(value="playlist")
	@OneToMany(mappedBy = "playlist", cascade = CascadeType.REMOVE)
	private List <MusicaPL> musicas;
	
	public Playlist() {
		
	}
	
	public Playlist(String id, String nome) {
		this.id = id;
		this.nome=nome;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<MusicaPL> getMusicas() {
		return musicas;
	}

	public void setMusicas(List<MusicaPL> musicas) {
		this.musicas = musicas;
	}
/*
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}*/
}
