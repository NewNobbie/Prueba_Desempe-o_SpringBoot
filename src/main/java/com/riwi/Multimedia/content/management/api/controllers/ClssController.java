package com.riwi.Multimedia.content.management.api.controllers;

import com.riwi.Multimedia.content.management.api.dto.request.ClssReq;
import com.riwi.Multimedia.content.management.api.dto.response.ClssResp;
import com.riwi.Multimedia.content.management.infrastructure.abstrac_services.IClssService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/class")
@AllArgsConstructor
public class ClssController {

    @Autowired
    private final IClssService clssService;

    @Operation(summary = "Show all classes", description = "Return all the classes with pagination")
    @GetMapping
    private ResponseEntity<Page<ClssResp>> getAll(
            @RequestParam(defaultValue = " ")String name,
            @RequestParam(defaultValue = " ")String description,
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "5") int size
    ){
        Pageable pageable = PageRequest.of(page -1, size);
        return ResponseEntity.ok(clssService.getAllActive(name, description, page -1, size));
    }

    @Operation(summary = "Find by id", description = "Returns the class with the provided id ")
    @GetMapping(path = "/{id}")
    public ResponseEntity<ClssResp> get(
            @PathVariable Long id

    ){
        return ResponseEntity.ok(this.clssService.get(id));
    }

    @Operation(summary = "Create new Class", description = "Insert the required data to create a new class")
    @PostMapping
    public ResponseEntity<ClssResp> insert(
            @Validated @RequestBody ClssReq request

            ){
        return ResponseEntity.ok(this.clssService.create(request));
    }


}
