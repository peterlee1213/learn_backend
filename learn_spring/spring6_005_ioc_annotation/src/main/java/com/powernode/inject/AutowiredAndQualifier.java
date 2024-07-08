package com.powernode.inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

//@Autowired根据类型进行自动装配
//@Autowired跟@Qualifier同时使用可实现根据名称进行自动装配
@Component
public class AutowiredAndQualifier {
    @Autowired
    private RandomClassChild autowiredByType;

    @Autowired
    @Qualifier("randomClassChild")
    private RandomClass autowiredByName;

    @Override
    public String toString() {
        return "AutowiredAndQualifier [autowiredByType=" + autowiredByType + ", autowiredByName=" + autowiredByName
                + "]";
    }

}

@Component
class RandomClass {
    @Value("random")
    private String name;

    @Override
    public String toString() {
        return "RandomClass [name=" + name + "]";
    }

}

@Component
class RandomClassChild extends RandomClass {
    @Value("child random class")
    private String childname;

    @Override
    public String toString() {
        return "RandomClassChild [childname=" + childname + ", toString()=" + super.toString() + "]";
    }

}
