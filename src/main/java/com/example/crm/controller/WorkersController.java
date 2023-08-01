package com.example.crm.controller;

import com.example.crm.dto.WorkerDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/workers")

public class WorkersController {
    @GetMapping
    @Operation(summary = "get all workers",
            tags = {"Workers"},
            method = "GET"
    )
    public ResponseEntity<List<WorkerDto>> findAll() {
        return ResponseEntity.ok(List.of());
    }

    @PostMapping
    @Operation(summary = "Save worker",
            tags = "Workers",
            method = "POST",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "worker to save"),
            responses = {
                    @ApiResponse(responseCode = "201", description = "Worker created successfully. Returns saved worker"),
                    @ApiResponse(responseCode = "460", description = "Email, username and Phone number must not be null or empty"),
                    @ApiResponse(responseCode = "465", description = "This user already exist"),
                    @ApiResponse(responseCode = "461",description = "Invalid mail address")
            }
    )
    public ResponseEntity<WorkerDto> save(@RequestBody WorkerDto worker) {
        return ResponseEntity.status(HttpStatus.CREATED).body(null);
    }

    @Operation(
            summary = "Updating user",
            tags = {"Workers"},
            method = "PUT",
            description = "Update worker info by username",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Worker to update. Updating performance by worker username."
            ),
            responses = {
                    @ApiResponse(responseCode = "200", description = "Worker updated successfully."),
                    @ApiResponse(responseCode = "404", description = "Worker nor found.")
            }
    )
    @PutMapping
    public ResponseEntity<WorkerDto> update(@RequestBody WorkerDto dto) {
        return ResponseEntity.ofNullable(null);
    }

}
