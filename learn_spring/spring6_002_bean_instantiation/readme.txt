Spring为Bean提供了多种实例化方式,通常包括四种

1. 通过构造方法
2. 通过简单工厂模式(simple factory)
3. 通过factory-bean实例化(factory method)
4. 通过FactoryBean接口实例化
    在第三种实例化方法中,我首先要实例化工厂类,然后再调用工厂实例的某个具体方法才能创建具体产品实例,这就意味着我要在xml文件中创建两个bean--具体工厂bean和具体产品bean
    这种实例化方法是,只要我的具体工厂类实现了FactoryBean的接口,就不需要再专门写一个bean去实例化具体工厂类了