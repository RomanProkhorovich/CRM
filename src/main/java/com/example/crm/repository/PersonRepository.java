package com.example.crm.repository;

import com.example.crm.model.Person;
import com.example.crm.model.Worker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@NoRepositoryBean
public interface PersonRepository extends JpaRepository<Person,Long> {
    Optional<Person> findByUsername(String username);

}
