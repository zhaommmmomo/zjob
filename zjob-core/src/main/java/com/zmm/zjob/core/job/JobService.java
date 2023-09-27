package com.zmm.zjob.core.job;

import com.zmm.zjob.core.ZJobConfig;
import com.zmm.zjob.core.api.IJobApi;
import com.zmm.zjob.core.common.Result;
import com.zmm.zjob.core.dao.IJobDao;
import com.zmm.zjob.core.dao.JobDao;
import io.vertx.core.Future;

import java.util.List;

public class JobService implements IJobApi {

    private final IJobDao jobDao;

    public JobService(ZJobConfig baseConfig) {
        jobDao = new JobDao(baseConfig);
    }

    @Override
    public Result<Long> create(Job job) {
        Future<Long> future = jobDao.create(job);

        return null;
    }

    @Override
    public Result<Boolean> stop(long jobId) {
        return null;
    }

    @Override
    public Result<Boolean> resume(long jobId) {
        return null;
    }

    @Override
    public Result<Boolean> delete(long jobId) {
        return null;
    }

    @Override
    public Result<List<Job>> getAllJobs(int page, int size) {
        return null;
    }
}
