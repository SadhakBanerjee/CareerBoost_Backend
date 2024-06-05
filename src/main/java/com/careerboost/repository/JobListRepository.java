package com.careerboost.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.careerboost.entity.JobList;

@Repository
public interface JobListRepository extends JpaRepository<JobList, Long> {
	
}
