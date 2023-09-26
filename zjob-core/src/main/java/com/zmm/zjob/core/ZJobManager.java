package com.zmm.zjob.core;

import com.zmm.zjob.core.db.IZJobDB;
import com.zmm.zjob.core.db.SimpleJobDB;
import com.zmm.zjob.core.execute.IZJobExecutor;
import com.zmm.zjob.core.execute.SimpleExecutor;
import com.zmm.zjob.core.schedule.IZJobScheduler;
import com.zmm.zjob.core.schedule.SimpleScheduler;

import java.util.Iterator;
import java.util.ServiceLoader;

public class ZJobManager {

    private final IZJobScheduler DEFAULT_SCHEDULER = new SimpleScheduler();
    private final IZJobExecutor DEFAULT_EXECUTOR = new SimpleExecutor();
    private final IZJobDB DEFAULT_DB = new SimpleJobDB();
    private IZJobScheduler scheduler;
    private IZJobExecutor executor;
    private IZJobDB jobDB;

    public ZJobManager() {
        init();
    }

    public void init() {
        // read base config
        readConfig();

        // init core component
        initCoreComponents();

        // load job and config from db
        loadData();

        // start
        start();
    }

    private void readConfig() {

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

        // job db
    }

    private void loadData() {

    }

    private void start() {

    }

    public void stop() {

    }
}
