package it.jaita88.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="recensioni")
public class Recensione {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	@Column(name="titolo", nullable = false)
	private String titolo;
	@Column(name="testo", nullable = false)
	private String testo;
	@Column(name="username", nullable = false)
	private String username;
	public Recensione() {
	}
	public Recensione(Integer id, String titolo, String testo, String username) {
		
		this.id = id;
		this.titolo = titolo;
		this.testo = testo;
		this.username = username;
	}
	public Recensione(String titolo, String testo, String username) {
		this.titolo = titolo;
		this.testo = testo;
		this.username = username;
	}
	public Recensione(String titolo, String testo) {
		this.titolo = titolo;
		this.testo = testo;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitolo() {
		return titolo;
	}
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	public String getTesto() {
		return testo;
	}
	public void setTesto(String testo) {
		this.testo = testo;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	@Override
	public String toString() {
		return "Recensione [id=" + id + ", titolo=" + titolo + ", testo=" + testo + ", username=" + username + "]";
	}
	
	

	
}
