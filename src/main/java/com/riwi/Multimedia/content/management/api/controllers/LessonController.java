package com.riwi.Multimedia.content.management.api.controllers;

import com.riwi.Multimedia.content.management.api.dto.request.LessonReq;
import com.riwi.Multimedia.content.management.api.dto.response.LessonResp;
import com.riwi.Multimedia.content.management.infrastructure.abstrac_services.ILessonService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/lesson")
@AllArgsConstructor
public class LessonController {

    @Autowired
    private final ILessonService lessonService;


    @Operation(summary = "Create new Lesson", description = "Add required data to create new lesson")
    @PostMapping
    public ResponseEntity<LessonResp> insert(
            @Validated @RequestBody LessonReq request
            ){
        return ResponseEntity.ok(this.lessonService.create(request));
    }

    @Operation(summary = "Show all lesson(s)", description = "Return all lesson(s) pagination")
    @GetMapping
    public ResponseEntity<Page<LessonResp>> getAll(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = " ") String name
    ){
        return ResponseEntity.ok(this.lessonService.getAll(page-1,size,name));
    }

    @Operation(summary = "Find by ID", description = "Returns lesson with the ID given")
    @GetMapping(path = "/{id}")
    public ResponseEntity<LessonResp> get(
            @PathVariable Long id
    ){
        return ResponseEntity.ok(this.lessonService.get(id));
    }


    @Operation(summary = "Disable lesson", description = "Enter the ID to disable the lesson")
    @PatchMapping(path = "/{id}/disable")
    public ResponseEntity<LessonResp> disable(
            @PathVariable Long id
    ){
        return ResponseEntity.ok(this.lessonService.disable(id));
    }


    @Operation(summary = "Search multimedia by ID", description = "Return the multimedia for the ID given")
    @GetMapping(path = "/{id}/multimedia")
    public ResponseEntity<LessonResp> getMulti(
            @PathVariable Long id
    ){
        return ResponseEntity.ok(this.lessonService.get(id));
    }
}
