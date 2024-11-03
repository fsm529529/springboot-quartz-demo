package com.kinpoway.quartzdemo.config;

import org.quartz.spi.TriggerFiredBundle;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.scheduling.quartz.AdaptableJobFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 解决SpringBoot不能在Quartz的Job中注入Bean的问题
 */
@Component
public class JobFactory extends AdaptableJobFactory {

    @Resource
    private AutowireCapableBeanFactory factory;

    @Override
    protected Object createJobInstance(TriggerFiredBundle bundle) throws Exception {
        Object job = super.createJobInstance(bundle);
        this.factory.autowireBean(job);
        return job;
    }

}
