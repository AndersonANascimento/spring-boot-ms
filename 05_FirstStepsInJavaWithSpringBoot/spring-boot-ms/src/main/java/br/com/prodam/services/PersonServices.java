package br.com.prodam.services;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import br.com.prodam.model.Person;

@Service
public class PersonServices {
    private final AtomicLong counter = new AtomicLong();
    private Logger logger = Logger.getLogger(PersonServices.class.getName());

    public List<Person> findAll() {
        logger.info("Buscando todas as pessoas...");
        List<Person> persons = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            Person person = mockPerson(i);
            persons.add(person);
        }
        return persons;
    }

    public Person findById(String id) {
        logger.info("Buscando uma pessoa por id...");
        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Anderson");
        person.setLastName("Nascimento");
        person.setAddress("Manaus-AM, Brasil");
        person.setGender("Masculino");
        return person;
    }
    
    private Person mockPerson(int i) {
        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Name " + i);
        person.setLastName("LastName " + i);
        person.setAddress("Address " + i);
        person.setGender("Masculino");
        return person;
    }

}
