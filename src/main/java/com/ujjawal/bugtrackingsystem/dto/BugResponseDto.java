package com.ujjawal.bugtrackingsystem.dto;

import java.time.LocalDateTime;

import com.ujjawal.bugtrackingsystem.entity.BugPriority;
import com.ujjawal.bugtrackingsystem.entity.BugStatus;

public class BugResponseDto {

    private Long id;
    private String title;
    private String description;
    private BugStatus status;
    private BugPriority priority;
    private LocalDateTime createdAt;
    
    public BugResponseDto(){}

    public BugResponseDto(Long id, String title, String description, BugStatus status, BugPriority priority, LocalDateTime createdAt)
    {
        this.id=id;
        this.title=title;
        this.description=description;
        this.priority=priority;
        this.status=status;
        this.createdAt=createdAt;


        

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BugStatus getStatus() {
        return status;
    }

    public void setStatus(BugStatus status) {
        this.status = status;
    }

    public BugPriority getPriority() {
        return priority;
    }

    public void setPriority(BugPriority priority) {
        this.priority = priority;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
