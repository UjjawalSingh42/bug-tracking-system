package com.ujjawal.bugtrackingsystem.service;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.stereotype.Service;

import com.ujjawal.bugtrackingsystem.entity.Bug;
import com.ujjawal.bugtrackingsystem.entity.BugStatus;
import com.ujjawal.bugtrackingsystem.repository.BugRepository;

@Service
public class BugService {
    private final BugRepository bugRepository;

    public BugService(BugRepository bugRepository) {
        this.bugRepository = bugRepository;
    }

    public Bug createBug(Bug bug) {

        bug.setStatus(BugStatus.OPEN); // Keep initial status open
        bug.setCreatedAt(LocalDateTime.now()); // keeps the time a bug created

        return bugRepository.save(bug);
    }

    public List<Bug> getAllBugs() {
        return bugRepository.findAll();
    }

    public Bug getBugById(Long id) {
        return bugRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Bug not found"));
    }

    public Bug updateBug(Long id, Bug updateBug) {
        Bug existingBug = getBugById(id);
        existingBug.setStatus(updateBug.getStatus());
        existingBug.setTitle(updateBug.getTitle());
        existingBug.setDescription(updateBug.getDescription());
        existingBug.setPriority(updateBug.getPriority());

        return bugRepository.save(existingBug);
    }

    public void deleteBug(Long id){
        Bug existingBug = getBugById(id);
        bugRepository.delete(existingBug);
    }
}
