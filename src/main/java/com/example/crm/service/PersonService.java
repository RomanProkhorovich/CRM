package com.example.crm.service;

import com.example.crm.exceptions.EmailException;
import com.example.crm.exceptions.PersonAlreadyExistException;
import com.example.crm.exceptions.PersonalDataException;
import com.example.crm.model.Person;
import com.example.crm.model.Worker;
import com.example.crm.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.stereotype.Service;

import javax.swing.plaf.PanelUI;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PersonService {
    private final PersonRepository personRepository;

    private static void validateEmail(String mail) {
        if (!EmailValidator.getInstance().isValid(mail)) {
            throw new EmailException();
        }
    }

    private static void stringIsNotNullAndNotBlank(String number) {
        if (number == null || number.isBlank())
            throw new PersonalDataException();
    }

    public Optional<Person> findById(Long id) {
        return personRepository.findById(id);
    }

    public List<Person> findAll() {
        return personRepository.findAll();
    }

    public void delete(Long id) {
        personRepository.deleteById(id);
    }

    public Person save(Person person) {

        stringIsNotNullAndNotBlank(person.getEmail());
        stringIsNotNullAndNotBlank(person.getPhoneNumber());
        stringIsNotNullAndNotBlank(person.getUsername());
        validateEmail(person.getEmail());

        checkUniquePerson(person);
        return personRepository.save(person);
    }

    //for security
    public Optional<Person> findByUsername(String username) {
        return personRepository.findByUsername(username);
    }

    private void checkUniquePerson(Person person) {
        if (this.findByUsername(person.getUsername()).isPresent())
            throw new PersonAlreadyExistException();
    }

    public void update(Person person) {
        var p = this.findById(person.getId()).orElseThrow();
    }



}
