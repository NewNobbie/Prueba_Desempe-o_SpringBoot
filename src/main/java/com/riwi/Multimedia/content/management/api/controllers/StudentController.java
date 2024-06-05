package com.riwi.Multimedia.content.management.api.controllers;

import com.riwi.Multimedia.content.management.api.dto.request.StudentReq;
import com.riwi.Multimedia.content.management.api.dto.response.StudentResp;
import com.riwi.Multimedia.content.management.infrastructure.abstrac_services.IStudentService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.security.PermitAll;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
@AllArgsConstructor
public class StudentController {

    @Autowired
    private final IStudentService studentService;

    @Operation(summary = "Show all registers", description = "Returns all paginated registers ")
    @GetMapping
    public ResponseEntity<Page<StudentResp>> getAllStudent(
            @RequestParam(defaultValue = " ") String name,
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "5") int size
    ){
        Pageable pageable = PageRequest.of(page -1, size);
        return ResponseEntity.ok(studentService.getAll(pageable));
    }

    @Operation(summary = "Search for ID", description = "Return the student with the provided id")
    @GetMapping(path = "/{id}")
    public ResponseEntity<StudentResp> get(
            @PathVariable Long id
    ){
        return ResponseEntity.ok(this.studentService.get(id));
    }

    @Operation(summary = "Create new register", description = "Add the required data to create a new student")
    @PostMapping
    public ResponseEntity<StudentResp> insert(
            @Validated @RequestParam StudentReq request
            ){
        return ResponseEntity.ok(this.studentService.create(request));
    }


    @Operation(summary = "Update an existing student", description = "Add ID of student and the new data")
    @PutMapping(path = "/{id}")
    public ResponseEntity<StudentResp> update(
            @Validated @RequestBody StudentReq request,
            @PathVariable Long id
            ){
        return ResponseEntity.ok(this.studentService.update(id,request));
    }

    @Operation(summary = "Disable the student",description = "Enter the ID of student to disable")
    @PatchMapping(path = "/{id}/disable")
    public ResponseEntity<StudentResp> disable(
            @PathVariable Long id
    ){
        return ResponseEntity.ok(this.studentService.disable(id));
    }





}
