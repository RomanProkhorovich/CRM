package com.example.crm.repository;

import com.example.crm.model.Service;
import com.example.crm.model.ServiceType;
import com.example.crm.model.Worker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface ServiceRepository extends JpaRepository<Service,Long> {
    Set<Service> findByWorker(Worker worker);
    Set<Service> findByServiceType(ServiceType type);
}
