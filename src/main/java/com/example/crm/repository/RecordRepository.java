package com.example.crm.repository;

import com.example.crm.model.Customer;
import com.example.crm.model.Record;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Calendar;
import java.util.Set;

@Repository
public interface RecordRepository extends JpaRepository<Record, Long> {
    Set<Record> findRecordsByVisitingDateAfterAndVisitingDateBefore(Calendar start
            , Calendar end);

    Set<Record> findAllByCustomer(Customer customer);
}
