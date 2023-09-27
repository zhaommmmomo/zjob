package com.zmm.zjob.core.job;

public class Job {
    private Long id;
    private JobType type;
    private Integer state;

    public Job() {
    }

    public Job(Long id, JobType type, Integer state) {
        this.id = id;
        this.type = type;
        this.state = state;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public JobType getType() {
        return type;
    }

    public void setType(JobType type) {
        this.type = type;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Job{" +
                "id=" + id +
                ", type=" + type +
                ", state=" + state +
                '}';
    }
}
