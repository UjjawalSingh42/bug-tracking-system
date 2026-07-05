package com.ujjawal.bugtrackingsystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ujjawal.bugtrackingsystem.entity.Bug;
import com.ujjawal.bugtrackingsystem.entity.BugPriority;
import com.ujjawal.bugtrackingsystem.entity.BugStatus;

public interface BugRepository extends JpaRepository<Bug, Long> {

    List<Bug> findByStatus(BugStatus status);

    List<Bug> findByPriority(BugPriority priority);

    List<Bug> findByTitleContaining(String title);
}
