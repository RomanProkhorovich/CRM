package repository;

import model.Customer;
import model.Record;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Set;

@Repository
public interface RecordRepository extends JpaRepository<Record,Long> {
    Set<Record> findRecordsByVisitingDateAfterAndVisitingDateBefore(LocalDateTime start
            ,LocalDateTime end);

    Set<Record> findAllByCustomer(Customer customer);
}
