package com.example.crm.repository;

import com.example.crm.model.Worker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkerRepository extends JpaRepository<Worker,Long> {
    Worker findByEmail(String email);
    Worker findByPhoneNumber(String phoneNumber);

}
