package it.jaita88.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.jaita88.model.Recensione;
import it.jaita88.repositories.RecensioneRepository;

@Service
public class RecensioneServiceDB implements RecensioneService {
	
	@Autowired 
	RecensioneRepository repository;
	@Override
	public List<Recensione> getRecensioni() {
		return (List<Recensione>) repository.findAll();	
	}

	@Override
	public Recensione getRecensioneById(Integer id) {
		Optional<Recensione> a = repository.findById(id);
		if(a.isPresent()) {
			return a.get();
		}
		return null;
	}

	@Override
	public boolean addRecensione(Recensione recensione) {
		Recensione r = repository.save(recensione);
		return true;
	}

	@Override
	public boolean updateRecensione(Integer id, Recensione recensione) {
		if(repository.existsById(id)) {
			Recensione a = repository.findById(id).get();
			a.setTesto(recensione.getTesto());
			a.setTitolo(recensione.getTitolo());
			a.setUsername(recensione.getUsername());
			repository.save(a);
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteRecensione(Integer id) {
		if(repository.existsById(id)) {
			repository.deleteById(id);
			return true;
		}
		return false;
	}

}
