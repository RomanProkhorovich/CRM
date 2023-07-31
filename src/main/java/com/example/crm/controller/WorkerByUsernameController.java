package com.example.crm.controller;

import com.example.crm.dto.WorkerDto;
import com.example.crm.repository.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/workers/{username}")
@RestController
@RequiredArgsConstructor
public class WorkerByUsernameController {
    private final RecordRepository repository;
    private final ServiceRepository serviceRepository;
    private final ServiceTypeRepository serviceTypeRepository;
    private final WorkerRepository workerRepository;
    private final CustomerRepository customerRepository;

    @GetMapping
    @Operation(
            summary = "Get worker by username",
            tags = {"Workers"},
            method = "GET",
            description = "Get a worker by username",
            operationId = "get_user_by_username",
            parameters = {@Parameter(name = "username", required = true, in= ParameterIn.PATH, example = "username")},
            responses = {
                    @ApiResponse(responseCode = "200", description = "Get worker successfully."),
                    @ApiResponse(responseCode = "404", description = "Worker nor found.")
            }
    )
    public ResponseEntity<WorkerDto> getByUsername(@PathVariable String username){
        return ResponseEntity.ofNullable(null);
    }
}
