package com.example.crm.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;
import com.example.crm.model.Worker;

import java.util.Objects;

@Data
@Builder
public class WorkerDto {
    @NotNull
    protected String firstname;
    @NotNull
    protected String lastname;
    @NotNull
    protected String email;
    @NotNull
    protected String phoneNumber;

    private float salary;

    public static Worker map(WorkerDto dto) {
        return Worker.builder()
                .email(dto.getEmail())
                .firstname(dto.getFirstname())
                .lastname(dto.getLastname())
                .salary(dto.getSalary())
                .phoneNumber(dto.getPhoneNumber())
                .build();
    }

    public static WorkerDto map(Worker worker) {
        return WorkerDto.builder()
                .email(worker.getEmail())
                .firstname(worker.getFirstname())
                .lastname(worker.getLastname())
                .salary(worker.getSalary())
                .phoneNumber(worker.getPhoneNumber())
                .build();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WorkerDto worker = (WorkerDto) o;
        return phoneNumber.equals(worker.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(phoneNumber);
    }
}
