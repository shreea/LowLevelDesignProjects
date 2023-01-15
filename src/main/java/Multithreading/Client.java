package Multithreading;

import Multithreading.MultithreadedTaskScheduler.models.Job;
import Multithreading.MultithreadedTaskScheduler.models.enums.JobRecurrenceType;
import Multithreading.MultithreadedTaskScheduler.models.jobImpl.AutoCloseBigMatters;
import Multithreading.MultithreadedTaskScheduler.services.JobSchedulerService;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class Client {
    public static void main(String[] args) {
        Job autoCloseJob = new AutoCloseBigMatters(new Date(), JobRecurrenceType.HOURLY, "AutoCloseBigMatters1");
        List<Job> jobList = new LinkedList<>();
        jobList.add(autoCloseJob);
        JobSchedulerService jobSchedulerService = new JobSchedulerService(jobList);

        System.out.println("Starting job scheduler service");
        jobSchedulerService.executeJobs();
        System.out.println("Ending job scheduler service");
    }
}
