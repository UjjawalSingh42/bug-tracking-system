package com.ujjawal.bugtrackingsystem.dto;

import com.ujjawal.bugtrackingsystem.entity.BugPriority;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class BugRequestDto {
    @NotBlank(message = "Title cannot be Blank")
    @Size(max = 100, message = "Title cannot be more than 100 characters")
    private String title;
    
    @NotBlank(message = "Description cannot be Blank")
    @Size(max = 1000, message = "Description cannot be more than 1000 characters")
    private String description;
    
    @NotNull(message = "Priority is required")
    private BugPriority priority;

    public BugRequestDto(){}

    public BugRequestDto(String title, String description, BugPriority priority){
        this.title=title;
        this.description=description;
        this.priority=priority;
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

    public BugPriority getPriority() {
        return priority;
    }

    public void setPriority(BugPriority priority) {
        this.priority = priority;
    }

    
}
