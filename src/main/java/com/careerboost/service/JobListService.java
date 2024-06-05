package com.careerboost.service;

import com.careerboost.entity.JobList;
import java.util.List;
import java.util.Optional;

public interface JobListService {
    List<JobList> getAllJobs();
    Optional<JobList> getJobById(Long id);
    JobList createJob(JobList jobList);
    JobList updateJob(Long id, JobList jobList);
    void deleteJob(Long id);
}
