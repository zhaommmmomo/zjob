package com.zmm.zjob.core.dao;

import com.zmm.zjob.core.job.Job;
import io.vertx.core.Future;

import java.util.List;

public interface IJobDao {

    Future<Long> create(Job job);

    Future<Boolean> updateJobState(long jobId, int state);

    Future<Boolean> delete(long jobId);

    Future<List<Job>> getAllJobs(int offset, int limit);

    Future<Void> close();
}
