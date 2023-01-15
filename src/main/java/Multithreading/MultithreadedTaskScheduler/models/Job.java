package Multithreading.MultithreadedTaskScheduler.models;

import Multithreading.MultithreadedTaskScheduler.models.enums.CurrentJobState;
import Multithreading.MultithreadedTaskScheduler.models.enums.JobRecurrenceType;
import Multithreading.MultithreadedTaskScheduler.models.enums.JobStatus;
import Multithreading.MultithreadedTaskScheduler.services.JobAction;
import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Data
public abstract class Job implements JobAction {
    private UUID jobId;
    private String jobTitle;
    private Date firstStartTime;
    private Date nextStartTime;
    private Date endTime;
    private CurrentJobState currentJobState;
    private JobStatus jobStatus;
    private long processingTime;
    private JobRecurrenceType jobRecurrenceType;
    public Job(Date firstStartTime, JobRecurrenceType jobRecurrenceType, String jobTitle) {
        this.jobId = UUID.randomUUID();
        this.firstStartTime = firstStartTime;
        this.currentJobState = CurrentJobState.NOT_STARTED;
        this.jobStatus = JobStatus.ACTIVE;
        this.jobRecurrenceType = jobRecurrenceType;
        this.jobTitle = jobTitle;
    }

    protected void setProcessingTime(long processingTime) {
        this.processingTime = processingTime;
    }
    protected void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
    protected void setCurrentJobState(CurrentJobState currentJobState) {
        this.currentJobState = currentJobState;
    }
    protected void setJobStatus(JobStatus jobStatus) {
        this.jobStatus = jobStatus;
    }
    protected void nextStartTime(Date nextStartTime) {
        this.nextStartTime = nextStartTime;
    }
}
