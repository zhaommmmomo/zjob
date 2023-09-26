package com.zmm.zjob.core.db;

import com.zmm.zjob.core.job.Job;

public interface IZJobDB {

    long create(Job job);

    boolean update(Job job);

    boolean stop(long jobId);

    boolean resume(long jobId);

    boolean delete(long jobId);
}
