package com.zmm.zjob.core.api;

import com.zmm.zjob.core.job.Job;

public interface IJobApi {

    boolean create(Job job);

    boolean update(Job job);

    boolean stop(long jobId);

    boolean resume(long jobId);

    boolean delete(long jobId);
}
