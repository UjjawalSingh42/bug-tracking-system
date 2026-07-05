package com.ujjawal.bugtrackingsystem.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ujjawal.bugtrackingsystem.entity.Bug;
import com.ujjawal.bugtrackingsystem.service.BugService;

@RestController
@RequestMapping("/api/bugs")
public class BugController {
    private final BugService bugService;

    public BugController(BugService bugService) {
        this.bugService = bugService;
    }

    @PostMapping
    public Bug createBug(@RequestBody Bug bug) {
        return bugService.createBug(bug);
    }

    @GetMapping
    public List<Bug> getAllBugs() {
        return bugService.getAllBugs();
    }

    @GetMapping("/{id}")
    public Bug getBugById(@PathVariable Long id) {
        return bugService.getBugById(id);
    }

    @PutMapping("/{id}")
    public Bug updateBug(@PathVariable Long id,
            @RequestBody Bug bug) {

        return bugService.updateBug(id, bug);
    }

    @DeleteMapping("/{id}")
    public void deleteBug(@PathVariable Long id){
        bugService.deleteBug(id);
    }

}
