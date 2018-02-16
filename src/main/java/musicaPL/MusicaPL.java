 package musicaPL;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

import playlist.Playlist;

@Entity
public class MusicaPL {
		
	@Id
	private String id;
	private String nome;
	private String album;
	private String artista;
			
	@JsonBackReference(value = "playlist") 
	@ManyToOne
	private Playlist playlist;
 	
	public MusicaPL(String id, String nome, String album, String artista, String playlistId) {
		this.id = id;
		this.nome = nome;
		this.album = album;
		this.artista = artista;
		this.playlist = new Playlist(playlistId, playlistId);
	}

	public MusicaPL() {
		
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
		
	public String getArtista() {
		return artista;
	}

	public void setArtista(String artista) {
		this.artista = artista;
	}

	public Playlist getPlaylist() {
		return playlist;
	}

	public void setPlaylist(Playlist playlist) {
		this.playlist = playlist;
	}
}
