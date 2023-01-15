package Multithreading.MultithreadedTaskScheduler.services;

import Multithreading.MultithreadedTaskScheduler.comparators.JobComparatorOnStartTime;
import Multithreading.MultithreadedTaskScheduler.models.enums.JobStatus;
import Multithreading.MultithreadedTaskScheduler.models.Job;

import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.PriorityQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class JobSchedulerService {
    ExecutorService executorService = Executors.newFixedThreadPool(4);
    private final PriorityQueue<Job> jobsInLine;

    public JobSchedulerService(List<Job> jobs) {
        this.jobsInLine = new PriorityQueue<>(new JobComparatorOnStartTime());
        jobsInLine.addAll(jobs);
    }
    public void executeJobs() {
        while (!jobsInLine.isEmpty()) {
            Date currentTime = new Date();
            if (jobsInLine.peek().getNextStartTime().compareTo(currentTime) < 1) {
                executorService.submit(() -> {
                    Job curentJob = jobsInLine.poll();
                    curentJob.action();
                    curentJob.setNextStartTime(curentJob.getNextStartTime());
                });
            }
        }
    }
}
