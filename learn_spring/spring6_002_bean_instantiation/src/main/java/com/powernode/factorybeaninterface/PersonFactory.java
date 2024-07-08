package com.powernode.factorybeaninterface;

import org.springframework.beans.factory.FactoryBean;

/**
 * 具体工厂角色
 */
public class PersonFactory implements FactoryBean<Person> {

    @Override
    public Person getObject() throws Exception {
        // TODO Auto-generated method stub
        return new Person();
    }

    @Override
    public Class getObjectType() {
        // TODO Auto-generated method stub
        return null;
    }

}
