package br.com.prodam.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.prodam.model.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {

}
