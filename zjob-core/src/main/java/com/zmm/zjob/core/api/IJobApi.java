package com.zmm.zjob.core.api;

import com.zmm.zjob.core.common.Result;
import com.zmm.zjob.core.job.Job;

import java.util.List;

public interface IJobApi {

    Result<Long> create(Job job);

    Result<Boolean> stop(long jobId);

    Result<Boolean> resume(long jobId);

    Result<Boolean> delete(long jobId);

    Result<List<Job>> getAllJobs(int page, int size);
}
