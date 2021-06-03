package com.yuier.gamemall.config;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.*;

/**
 * @author NaiHeeee
 */
@Configuration
public class ThreadPoolConfig {
    /**    分析下继承关系：

        1、ThreadPoolTaskExecutor extends (2)ExecutorConfigurationSupport implements (3)AsyncListenableTaskExecutor, (4)SchedulingTaskExecutor
        2、 ExecutorConfigurationSupport extends CustomizableThreadFactory implements BeanNameAware, InitializingBean, DisposableBean
        3、public interface AsyncListenableTaskExecutor extends AsyncTaskExecutor
        4、public interface SchedulingTaskExecutor extends AsyncTaskExecutor
        从上继承关系可知：
            ThreadPoolExecutor是一个java类不提供spring生命周期和参数装配。
            ThreadPoolTaskExecutor实现了InitializingBean, DisposableBean ，xxaware等，具有spring特性
            AsyncListenableTaskExecutor提供了监听任务方法(相当于添加一个任务监听，提交任务完成都会回调该方法)
        简单理解：
            1、ThreadPoolTaskExecutor使用ThreadPoolExecutor并增强，扩展了更多特性
            2、ThreadPoolTaskExecutor只关注自己增强的部分，任务执行还是ThreadPoolExecutor处理。
            3、前者spring自己用着爽，后者离开spring我们用ThreadPoolExecutor爽。
        注意：ThreadPoolTaskExecutor 不会自动创建ThreadPoolExecutor需要手动调initialize才会创建
        如果@Bean 就不需手动，会自动InitializingBean的afterPropertiesSet来调initialize*/
    @Bean("threadPoolInstance")
    public ExecutorService  createThreadPoolInstance() {
        ThreadFactory threadFactory = new ThreadFactoryBuilder().setNameFormat("thread-pool-%d").build();
        ExecutorService threadPool = new ThreadPoolExecutor(10, 16, 60L, TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(100), threadFactory, new ThreadPoolExecutor.AbortPolicy());
        return threadPool;
    }
}
