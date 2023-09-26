package com.zmm.zjob.core.db;

import com.zmm.zjob.core.job.Job;

public class ZJobMySQL implements IZJobDB{

    @Override
    public long create(Job job) {
        return 0;
    }

    @Override
    public boolean update(Job job) {
        return false;
    }

    @Override
    public boolean stop(long jobId) {
        return false;
    }

    @Override
    public boolean resume(long jobId) {
        return false;
    }

    @Override
    public boolean delete(long jobId) {
        return false;
    }
}
