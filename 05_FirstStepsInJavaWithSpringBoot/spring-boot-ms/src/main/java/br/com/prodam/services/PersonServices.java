package br.com.prodam.services;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.prodam.exceptions.ResourceNotFoundException;
import br.com.prodam.model.Person;
import br.com.prodam.repositories.PersonRepository;

@Service
public class PersonServices {
	private Logger logger = Logger.getLogger(PersonServices.class.getName());

	@Autowired
	PersonRepository repository;

	public List<Person> findAll() {
		logger.info("Buscando todas as pessoas...");
		return repository.findAll();
	}

	public Person findById(Long id) {
		logger.info("Buscando uma pessoa por id=" + id + " ...");
		return repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Registro não encontrado para este ID=" + id + "!"));
	}

	public Person create(Person person) {
		logger.info("Criando uma pessoa...");
		return repository.save(person);
	}

	public Person update(Person person) {
		logger.info("Atualizando uma pessoa...");
		Person entity = repository.findById(person.getId())
				.orElseThrow(() -> new ResourceNotFoundException("Registro não encontrado para este ID=" + person.getId() + "!"));

		entity.setFirstName(person.getFirstName());
		entity.setLastName(person.getLastName());
		entity.setAddress(person.getAddress());
		entity.setGender(person.getGender());

		return repository.save(person);
	}

	public void delete(Long id) {
		logger.info("Deletando uma pessoa...");
		Person entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Registro não encontrado para este ID=" + id + "!"));
		repository.delete(entity);
	}
}
