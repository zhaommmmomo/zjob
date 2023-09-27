package com.zmm.zjob.core;

import com.zmm.zjob.core.execute.IZJobExecutor;
import com.zmm.zjob.core.execute.SimpleExecutor;
import com.zmm.zjob.core.schedule.IZJobScheduler;
import com.zmm.zjob.core.schedule.SimpleScheduler;

import java.util.Iterator;
import java.util.Objects;
import java.util.ServiceLoader;

public class ZJobManager {

    private static final ZJobConfig DEFAULT_CONFIG = new ZJobConfig();
    private static final IZJobScheduler DEFAULT_SCHEDULER = new SimpleScheduler();
    private static final IZJobExecutor DEFAULT_EXECUTOR = new SimpleExecutor();
    private static ZJobConfig baseConfig;
    private static IZJobScheduler scheduler;
    private static IZJobExecutor executor;

    public static void init(ZJobConfig baseConfig) {
        // read base config
        readConfig(baseConfig);

        // init core component
        initCoreComponents();

        // load job and config from db
        loadData();

        // start
        start();
    }

    private static void readConfig(ZJobConfig baseConfig) {
        if (Objects.isNull(baseConfig)) {
            baseConfig = new ZJobConfig();
        }

    }

    private static void initCoreComponents() {
        // scheduler
        ServiceLoader<IZJobScheduler> schedulers = ServiceLoader.load(IZJobScheduler.class);
        Iterator<IZJobScheduler> schedulersIterator = schedulers.iterator();
        scheduler = schedulersIterator.hasNext() ? schedulersIterator.next() : DEFAULT_SCHEDULER;

        // executor
        ServiceLoader<IZJobExecutor> executors = ServiceLoader.load(IZJobExecutor.class);
        Iterator<IZJobExecutor> executorsIterator = executors.iterator();
        executor = executorsIterator.hasNext() ? executorsIterator.next() : DEFAULT_EXECUTOR;

        // job db
    }

    private static void loadData() {

    }

    private static void start() {

    }

    public static ZJobConfig getBaseConfig() {
        return baseConfig;
    }

    public static IZJobScheduler getScheduler() {
        return scheduler;
    }

    public static IZJobExecutor getExecutor() {
        return executor;
    }

    public static void stop() {

    }
}
