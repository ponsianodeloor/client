package com.sofka.client.service;

import com.sofka.client.model.Person;
import com.sofka.client.repository.PersonRepository;
import com.sofka.client.service.utils.CommonApplications;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService extends CommonApplications {
    private final PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<Person> getAllPersons() {
        return personRepository.findAll();
    }

    public Person getPersonById(String id) {
        return personRepository.findById(id).orElseThrow(() -> new RuntimeException("Persona no encontrada"));
    }

    public Person getPersonByClientId(String clientId) {
        return personRepository.findByClientId(clientId);
    }

    public Person addPerson(Person person) {
        //validate if the person already exists
        if (personRepository.existsById(person.getIdentification())) {
            throw new RuntimeException("Ya existe una persona con esa identificación");
        }
        person.setAge(calculateAge(person.getBirthdate()));
        //antes de guardar la persona validar si es mayor de edad, en caso de RUC aplicar otras validaciones
        if (person.getAge() < 18) {
            throw new RuntimeException("La persona debe ser mayor de edad");
        }
        return personRepository.save(person);
    }

}
