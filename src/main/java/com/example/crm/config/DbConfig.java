package com.example.crm.config;

import com.example.crm.model.Customer;
import com.example.crm.model.Worker;
import com.example.crm.repository.CustomerRepository;
import com.example.crm.repository.WorkerRepository;
import com.example.crm.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class DbConfig {
    private final PersonService workerRepository;

    @Bean
    public void init() {
        workerRepository.save(Worker.builder()
                .email("p@gmail.com")
                .firstname("ROma")
                .lastname("Roma")
                .username("Roooma")
                .phoneNumber("89095492710")
                .salary(250)
                .build());
        workerRepository.save(Customer.builder()
                .email("pp@gmail.com")
                .firstname("Rama")
                .lastname("Raaaaaaaama")
                .username("Raaaaaaaaaaaaaaaaaame")
                .phoneNumber("89999999999")
                .status("elite")
                .build());
    }
}
