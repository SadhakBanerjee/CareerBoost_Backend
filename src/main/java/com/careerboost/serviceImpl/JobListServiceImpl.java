package com.careerboost.serviceImpl;

import com.careerboost.entity.JobList;
import com.careerboost.repository.JobListRepository;
import com.careerboost.service.JobListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobListServiceImpl implements JobListService {

    @Autowired
    private JobListRepository jobListRepository;

    @Override
    public List<JobList> getAllJobs() {
        return jobListRepository.findAll();
    }

    @Override
    public Optional<JobList> getJobById(Long id) {
        return jobListRepository.findById(id);
    }

    @Override
    public JobList createJob(JobList jobList) {
        return jobListRepository.save(jobList);
    }

    @Override
    public JobList updateJob(Long id, JobList jobList) {
        if (jobListRepository.existsById(id)) {
            jobList.setJobId(id);
            return jobListRepository.save(jobList);
        }
        return null;
    }

    @Override
    public void deleteJob(Long id) {
        jobListRepository.deleteById(id);
    }
}
