package Multithreading.MultithreadedTaskScheduler.comparators;

import Multithreading.MultithreadedTaskScheduler.models.Job;

import java.util.Comparator;

public class JobComparatorOnStartTime implements Comparator<Job> {
    @Override
    public int compare(Job job1, Job job2) {
        return job1.getNextStartTime().compareTo(job2.getNextStartTime());
    }
}
