package com.zmm.zjob.core.job;

public class SqlJob extends Job {

    @Override
    public JobType getJobType() {
        return JobType.SQL;
    }
}
