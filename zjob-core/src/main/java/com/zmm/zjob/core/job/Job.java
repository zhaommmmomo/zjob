package com.zmm.zjob.core.job;

public abstract class Job {
    public Long id;

    public Long getId() {
        return id;
    }

    public abstract JobType getJobType();
}
