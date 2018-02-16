 package artista;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import musica.Musica;

@Entity
public class Artista {
		
	@Id
	private String id;
	private String nome;
	
	@JsonManagedReference(value="artista")
	@OneToMany(mappedBy = "artista")
	private List <Musica> musicas;
	
	
	public Artista() {
		
	}
	
	public Artista(String id, String nome) {
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

	public List<Musica> getMusicas() {
		return musicas;
	}

	public void setMusicas(List<Musica> musicas) {
		this.musicas = musicas;
	}
}
