package com.ujjawal.bugtrackingsystem.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "bugs")
public class Bug {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Enumerated(EnumType.STRING)
    private BugStatus status;

    @Enumerated(EnumType.STRING)
    private BugPriority priority;
    
    private LocalDateTime createdAt;


    public Bug(){}


    public Bug(Long id, String title, String description, BugStatus status, BugPriority priority, LocalDateTime createdAt){
        this.id=id;
        this.title=title;
        this.description=description;
        this.status=status;
        this.priority=priority;
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
