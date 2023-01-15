package Multithreading.MultithreadedTaskScheduler.models.jobImpl;

import Multithreading.MultithreadedTaskScheduler.models.Job;
import Multithreading.MultithreadedTaskScheduler.models.enums.JobRecurrenceType;

import java.util.Date;

public class AutoCloseBigMatters extends Job{
    public AutoCloseBigMatters(Date startTime, JobRecurrenceType jobRecurrenceType, String jobTitle) {
        super(startTime, jobRecurrenceType, jobTitle);
    }
    @Override
    public void action() {
        for (int i = 0; i < 5000000; ++i) {
            System.out.println("Started " + getJobTitle());
            if (i % 100 == 0) {
                System.out.println("Executing " + getJobTitle());
            }
            System.out.println("Completed " + getJobTitle());
        }
    }
}
