package it.jaita88.services;

import java.util.List;

import it.jaita88.model.Recensione;

public interface RecensioneService {
	List<Recensione> getRecensioni();
	Recensione getRecensioneById(Integer id);
	boolean addRecensione(Recensione recensione);
	boolean updateRecensione(Integer id, Recensione recensione);
	boolean deleteRecensione(Integer id);
	
}
