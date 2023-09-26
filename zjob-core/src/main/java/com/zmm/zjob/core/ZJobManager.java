package com.zmm.zjob.core;

import com.zmm.zjob.core.execute.IZJobExecutor;
import com.zmm.zjob.core.execute.SimpleExecutor;
import com.zmm.zjob.core.schedule.IZJobScheduler;
import com.zmm.zjob.core.schedule.SimpleScheduler;

import java.util.Iterator;
import java.util.Objects;
import java.util.ServiceLoader;

public class ZJobManager {

    private final ZJobConfig DEFAULT_CONFIG = new ZJobConfig();
    private final IZJobScheduler DEFAULT_SCHEDULER = new SimpleScheduler();
    private final IZJobExecutor DEFAULT_EXECUTOR = new SimpleExecutor();
    private ZJobConfig baseConfig;
    private IZJobScheduler scheduler;
    private IZJobExecutor executor;

    public ZJobManager() {
        init(DEFAULT_CONFIG);
    }

    public ZJobManager(ZJobConfig baseConfig) {
        init(baseConfig);
    }

    public void init(ZJobConfig baseConfig) {
        // read base config
        readConfig(baseConfig);

        // init core component
        initCoreComponents();

        // load job and config from db
        loadData();

        // start
        start();
    }

    private void readConfig(ZJobConfig baseConfig) {
        if (Objects.isNull(baseConfig)) {
            baseConfig = new ZJobConfig();
        }

    }

    private void initCoreComponents() {
        // scheduler
        ServiceLoader<IZJobScheduler> schedulers = ServiceLoader.load(IZJobScheduler.class);
        Iterator<IZJobScheduler> schedulersIterator = schedulers.iterator();
        scheduler = schedulersIterator.hasNext() ? schedulersIterator.next() : DEFAULT_SCHEDULER;

        // executor
        ServiceLoader<IZJobExecutor> executors = ServiceLoader.load(IZJobExecutor.class);
        Iterator<IZJobExecutor> executorsIterator = executors.iterator();
        executor = executorsIterator.hasNext() ? executorsIterator.next() : DEFAULT_EXECUTOR;
    }

    private void loadData() {

    }

    private void start() {

    }

    public void stop() {

    }
}
