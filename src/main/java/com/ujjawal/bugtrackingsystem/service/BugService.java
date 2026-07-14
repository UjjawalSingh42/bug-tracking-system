package com.ujjawal.bugtrackingsystem.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

import com.ujjawal.bugtrackingsystem.dto.BugRequestDto;
import com.ujjawal.bugtrackingsystem.dto.BugResponseDto;
import com.ujjawal.bugtrackingsystem.entity.Bug;
import com.ujjawal.bugtrackingsystem.entity.BugStatus;
import com.ujjawal.bugtrackingsystem.exception.BugNotFoundException;
import com.ujjawal.bugtrackingsystem.repository.BugRepository;

@Service
public class BugService {
    private final BugRepository bugRepository;

    public BugService(BugRepository bugRepository) {
        this.bugRepository = bugRepository;
    }

    private BugResponseDto mapToResponseDto(Bug bug) {

        BugResponseDto responseDto = new BugResponseDto();

        responseDto.setId(bug.getId());
        responseDto.setTitle(bug.getTitle());
        responseDto.setDescription(bug.getDescription());
        responseDto.setPriority(bug.getPriority());
        responseDto.setStatus(bug.getStatus());
        responseDto.setCreatedAt(bug.getCreatedAt());
        return responseDto;

    }

    private Bug findBugById(Long id) {
        return bugRepository.findById(id)
                .orElseThrow(() -> new BugNotFoundException("Bug not found with ID: "+ id));

    }

    public BugResponseDto createBug(BugRequestDto requestDto) {

        Bug bug = new Bug();
        bug.setTitle(requestDto.getTitle());
        bug.setDescription(requestDto.getDescription());
        bug.setPriority(requestDto.getPriority());
        bug.setStatus(BugStatus.OPEN); // Keep initial status open
        bug.setCreatedAt(LocalDateTime.now()); // keeps the time a bug created

        Bug savedBug = bugRepository.save(bug);
        return mapToResponseDto(savedBug);
    }

    public List<BugResponseDto> getAllBugs() {
        List<Bug> bugs = bugRepository.findAll();
        List<BugResponseDto> responseList = new ArrayList<>();
        for (Bug bug : bugs) {
            responseList.add(mapToResponseDto(bug));
        }
        return responseList;
    }

    public BugResponseDto getBugById(Long id) {
        Bug bug = findBugById(id);
        return mapToResponseDto(bug);
    }

    public BugResponseDto updateBug(Long id, BugRequestDto requestDto) {
        Bug existingBug = findBugById(id);
        existingBug.setTitle(requestDto.getTitle());
        existingBug.setDescription(requestDto.getDescription());
        existingBug.setPriority(requestDto.getPriority());

        Bug savedBug = bugRepository.save(existingBug);
        return mapToResponseDto(savedBug);
    }

    public void deleteBug(Long id) {
        Bug existingBug = findBugById(id);
        bugRepository.delete(existingBug);
    }
}
