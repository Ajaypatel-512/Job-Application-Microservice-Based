package com.practise.jobms.job;

import com.practise.jobms.job.entity.Job;
import com.practise.jobms.job.service.JobService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class JobController {

//    @Autowired
    private JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping("/jobs")
    public ResponseEntity<List<Job>> findAll(){
        return new ResponseEntity<>(jobService.findAll(),HttpStatus.OK);
    }

    @PostMapping("/jobs")
    public ResponseEntity<String> createJob(@RequestBody Job job){
        jobService.createJob(job);
        return new ResponseEntity<>("Job Created Successfully",HttpStatus.CREATED);
    }

    @GetMapping("/jobs/{id}")
    public ResponseEntity<Job> getJobById(@PathVariable Long id){
//        return jobService.findJobById(id) == null ? null : jobService.findJobById(id);
        Job job = jobService.findJobById(id);
        if (job == null){
            return new ResponseEntity<>(job, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(job, HttpStatus.OK);
    }

    @DeleteMapping("/jobs/{id}")
    public ResponseEntity<String> deleteJobById(@PathVariable Long id){
        jobService.deleteJobById(id);
        return new ResponseEntity<>("Deleted Job Successfully", HttpStatus.OK);
    }

    @PutMapping("/jobs/{id}")
    public ResponseEntity<String> updateJob(@PathVariable Long id,@RequestBody Job updatedJob){
        boolean updated = jobService.updateJob(id,updatedJob);
        if (updated)
            return new ResponseEntity<>("Updated Job Successfully", HttpStatus.OK);
        return new ResponseEntity<>( HttpStatus.NOT_FOUND);
    }

}
