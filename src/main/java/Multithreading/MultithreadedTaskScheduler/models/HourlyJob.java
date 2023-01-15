package Multithreading.MultithreadedTaskScheduler.models;

import java.util.Date;

public abstract class HourlyJob extends Job{
    private int interval;
    public HourlyJob(Date firstStartTime, int interval) {
        super(firstStartTime);
        this.interval = interval;
    }
}
