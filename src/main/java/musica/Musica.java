 package musica;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;

import artista.Artista;
import playlist.Playlist;

@Entity
public class Musica {
		
	@Id
	private String id;
	private String nome;
	private String album;
	
	@JsonBackReference (value = "artista") 
	@ManyToOne
	private Artista artista;
	/*
	@JsonBackReference(value = "playlist") 
	@ManyToOne
	private Playlist playlist;*/
 	
	public Musica(String id, String nome, String album, String artistaId/*, String playlistId*/) {
		this.id = id;
		this.nome = nome;
		this.album = album;
		this.artista = new Artista(artistaId, artistaId);
		//this.playlist = new Playlist(playlistId, playlistId);
	}

	public Musica() {
		
	}
	
	public String getAlbum() {
		return album;
	}

	public void setAlbum(String album) {
		this.album = album;
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
	
	public Artista getArtista() {
		return artista;
	}

	public void setArtista(Artista artista) {
		this.artista = artista;
	}
/*
	public Playlist getPlaylist() {
		return playlist;
	}

	public void setPlaylist(Playlist playlist) {
		this.playlist = playlist;
	}*/
}
