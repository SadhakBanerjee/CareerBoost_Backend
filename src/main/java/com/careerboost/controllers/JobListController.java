package com.careerboost.controllers;

import com.careerboost.entity.JobList;
import com.careerboost.service.JobListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/CareerBoost/jobs")
public class JobListController {

    @Autowired
    private JobListService jobListService;

    @GetMapping
    public List<JobList> getAllJobs() {
        return jobListService.getAllJobs();
    }

    @GetMapping("/getJobById/{id}")
    public ResponseEntity<JobList> getJobById(@PathVariable Long id) {
        Optional<JobList> jobList = jobListService.getJobById(id);
        return jobList.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/create")
    public JobList createJob(@RequestBody JobList jobList) {
        return jobListService.createJob(jobList);
    }

    @PutMapping("/editJobById/{id}")
    public ResponseEntity<JobList> updateJob(@PathVariable Long id, @RequestBody JobList jobList) {
        JobList updatedJob = jobListService.updateJob(id, jobList);
        return updatedJob != null ? ResponseEntity.ok(updatedJob) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/deleteJobById/{id}")
    public ResponseEntity<Void> deleteJob(@PathVariable Long id) {
        jobListService.deleteJob(id);
        return ResponseEntity.noContent().build();
    }
}

//
//package com.careerboost.controllers;
//
//import com.careerboost.entity.JobList;
//import com.careerboost.service.JobListService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
//import io.swagger.annotations.ApiResponse;
//import io.swagger.annotations.ApiResponses;
//import io.swagger.annotations.ApiParam;
//
//import java.util.List;
//import java.util.Optional;
//
//@RestController
//@CrossOrigin("*")
//@RequestMapping("/CareerBoost/jobs")
//@Api(value = "Job List Controller", description = "Operations pertaining to job management")
//public class JobListController {
//
//    @Autowired
//    private JobListService jobListService;
//
//    @GetMapping
//    @ApiOperation(value = "Retrieve all job listings", response = List.class)
//    @ApiResponses(value = {
//        @ApiResponse(code = 200, message = "Successfully retrieved list"),
//        @ApiResponse(code = 500, message = "Internal server error")
//    })
//    public List<JobList> getAllJobs() {
//        return jobListService.getAllJobs();
//    }
//
//    @GetMapping("/getJobById/{id}")
//    @ApiOperation(value = "Retrieve a job listing by ID", response = JobList.class)
//    @ApiResponses(value = {
//        @ApiResponse(code = 200, message = "Successfully retrieved job"),
//        @ApiResponse(code = 404, message = "Job not found"),
//        @ApiResponse(code = 500, message = "Internal server error")
//    })
//    public ResponseEntity<JobList> getJobById(
//            @ApiParam(value = "ID of the job to be retrieved", required = true)
//            @PathVariable Long id) {
//        Optional<JobList> jobList = jobListService.getJobById(id);
//        return jobList.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
//    }
//
//    @PostMapping("/create")
//    @ApiOperation(value = "Create a new job listing", response = JobList.class)
//    @ApiResponses(value = {
//        @ApiResponse(code = 201, message = "Job created successfully"),
//        @ApiResponse(code = 400, message = "Invalid input"),
//        @ApiResponse(code = 500, message = "Internal server error")
//    })
//    public JobList createJob(
//            @ApiParam(value = "Job object to be created", required = true)
//            @RequestBody JobList jobList) {
//        return jobListService.createJob(jobList);
//    }
//
//    @PutMapping("/editJobById/{id}")
//    @ApiOperation(value = "Update a job listing by ID", response = JobList.class)
//    @ApiResponses(value = {
//        @ApiResponse(code = 200, message = "Job updated successfully"),
//        @ApiResponse(code = 404, message = "Job not found"),
//        @ApiResponse(code = 400, message = "Invalid input"),
//        @ApiResponse(code = 500, message = "Internal server error")
//    })
//    public ResponseEntity<JobList> updateJob(
//            @ApiParam(value = "ID of the job to be updated", required = true)
//            @PathVariable Long id,
//            @ApiParam(value = "Updated job object", required = true)
//            @RequestBody JobList jobList) {
//        JobList updatedJob = jobListService.updateJob(id, jobList);
//        return updatedJob != null ? ResponseEntity.ok(updatedJob) : ResponseEntity.notFound().build();
//    }
//
//    @DeleteMapping("/deleteJobById/{id}")
//    @ApiOperation(value = "Delete a job listing by ID")
//    @ApiResponses(value = {
//        @ApiResponse(code = 204, message = "Job deleted successfully"),
//        @ApiResponse(code = 404, message = "Job not found"),
//        @ApiResponse(code = 500, message = "Internal server error")
//    })
//    public ResponseEntity<Void> deleteJob(
//            @ApiParam(value = "ID of the job to be deleted", required = true)
//            @PathVariable Long id) {
//        jobListService.deleteJob(id);
//        return ResponseEntity.noContent().build();
//    }
//}
//
