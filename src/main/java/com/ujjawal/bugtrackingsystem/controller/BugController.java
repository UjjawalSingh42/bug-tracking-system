package com.ujjawal.bugtrackingsystem.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ujjawal.bugtrackingsystem.dto.BugRequestDto;
import com.ujjawal.bugtrackingsystem.dto.BugResponseDto;
import jakarta.validation.Valid;
import com.ujjawal.bugtrackingsystem.service.BugService;

@RestController
@RequestMapping("/api/bugs")
public class BugController {
    private final BugService bugService;

    public BugController(BugService bugService) {
        this.bugService = bugService;
    }

    @PostMapping
    public ResponseEntity<BugResponseDto> createBug(@Valid @RequestBody BugRequestDto requestDto) {
        BugResponseDto response = bugService.createBug(requestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<List<BugResponseDto>> getAllBugs() {
        List<BugResponseDto> bug = bugService.getAllBugs();
        return ResponseEntity.ok(bug);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BugResponseDto> getBugById(@PathVariable Long id) {

        BugResponseDto bug = bugService.getBugById(id);

        return ResponseEntity.ok(bug);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BugResponseDto> updateBug(@PathVariable Long id,
            @Valid @RequestBody BugRequestDto requestDto) {

        BugResponseDto updatedBug = bugService.updateBug(id, requestDto);
        return ResponseEntity.ok(updatedBug);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBug(@PathVariable Long id) {
        bugService.deleteBug(id);
        return ResponseEntity.noContent().build();
    }

}
