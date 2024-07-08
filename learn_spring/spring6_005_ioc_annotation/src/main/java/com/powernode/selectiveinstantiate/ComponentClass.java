package com.powernode.selectiveinstantiate;

import org.springframework.stereotype.Component;

@Component
public class ComponentClass {
    public ComponentClass() {
        System.out.println("ComponentClass constructor invoke");
    }
}
