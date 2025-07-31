package com.microservice.job.service;



import com.microservice.job.entity.Job;

import java.util.List;


public interface JobService {

    List<Job> findAll();
    void createJob(Job job);

    Job findJobById(Long id);

    boolean updateJob(Long id, Job job);


    boolean deleteJob(Long id);
}
