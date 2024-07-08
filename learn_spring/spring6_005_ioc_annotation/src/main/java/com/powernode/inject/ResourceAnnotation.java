package com.powernode.inject;

import org.springframework.stereotype.Component;

/**
 * 官方推荐使用
 * 
 * @Resource可完成简单/非简单类型的注入
 * @Resource可用在属性上/setter方法上
 * @Resource默认根据名称装配,未指定name时使用属性名作为name,再找不到的话通过类型自动装配
 */
@Component
public class ResourceAnnotation {

}
