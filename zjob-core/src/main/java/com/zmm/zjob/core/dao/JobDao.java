package com.zmm.zjob.core.dao;

import com.zmm.zjob.core.ZJobConfig;
import com.zmm.zjob.core.job.Job;
import com.zmm.zjob.core.job.JobType;
import io.vertx.core.Future;
import io.vertx.mysqlclient.MySQLClient;
import io.vertx.mysqlclient.MySQLConnectOptions;
import io.vertx.mysqlclient.MySQLPool;
import io.vertx.sqlclient.PoolOptions;
import io.vertx.sqlclient.templates.SqlTemplate;

import java.util.*;

public class JobDao implements IJobDao {

    private final static String CREATE_JOB_SQL = "insert into `z_job` values (#{id}, #{type}, #{state})";
    private final static String SELECT_ALL_JOB = "select * from `z_job` limit #{offset},#{limit}";
    private final MySQLPool mysqlPool;

    public JobDao(ZJobConfig baseConfig) {
        MySQLConnectOptions connectOptions = new MySQLConnectOptions()
                .setHost("localhost")
                .setPort(3306)
                .setDatabase("zjob")
                .setUser("root")
                .setPassword("admin123456.");
        PoolOptions poolOptions = new PoolOptions().setMaxSize(8);
        mysqlPool = MySQLPool.pool(connectOptions, poolOptions);
    }

    @Override
    public Future<Long> create(Job job) {
        return SqlTemplate
                .forUpdate(mysqlPool, CREATE_JOB_SQL)
                .mapFrom(Job.class)
                .execute(job)
                .map(sr -> sr.property(MySQLClient.LAST_INSERTED_ID));
    }

    @Override
    public Future<Boolean> updateJobState(long jobId, int state) {
        return null;
    }

    @Override
    public Future<Boolean> delete(long jobId) {
        return null;
    }

    @Override
    public Future<List<Job>> getAllJobs(int offset, int limit) {
        Map<String, Object> map = new HashMap<String, Object>() {{
            put("offset", offset);
            put("limit", limit);
        }};
        return SqlTemplate
                .forQuery(mysqlPool, SELECT_ALL_JOB)
                .mapTo(Job.class)
                .execute(map)
                .map(rowSet -> {
                    List<Job> tmpJobs = new ArrayList<>(rowSet.size());
                    rowSet.forEach(tmpJobs::add);
                    return tmpJobs;
                });
    }

    @Override
    public Future<Void> close() {
        return mysqlPool.close();
    }

    public static void main(String[] args) {
        JobDao jobDao = new JobDao(null);
        jobDao.create(new Job(null, JobType.SQL, 1));
        jobDao.close();
    }
}
