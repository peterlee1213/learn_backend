package com.powernode.Seven;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

//注意:这个Bean后处理器将作用于这个配置文件中所有的Bean
public class LogBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        // TODO Auto-generated method stub
        System.out.println("2.5 Bean后处理器after方法");
        return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        // TODO Auto-generated method stub
        System.out.println("2.5 Bean后处理器before方法");
        return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
    }

}
