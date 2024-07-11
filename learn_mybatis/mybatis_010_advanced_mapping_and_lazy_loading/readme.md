## 什么是高级映射

我不光从一张表查数据, 我可能从很多表联合查数据

高级映射讲两个:
1. 多对一映射
2. 一对多映射

```
学生表是这样的:

sid	sname	cid	
1	张三	1000	
2	李四	1000	
3	王五	1001	
4	赵六	1001	

班级表是这样的

cid	cname	
1000	高三一班	
1001	高三二班	

那我最后创建的POJO对象应该是这样的

public class Student{
    private Long sid;
    private String sname;
    private Clazz clazz;
}

public class Clazz{
    private Long cid;
    private String cname;
}

而不是在Student类中加一个cid属性

```

## 多对一(本例中多个学生对应一个班级, 本例中着重构建Student对象)
场景:
上述两个表中, 查询学生以及其对应的班级信息

#### 一条sql语句, 级联属性映射

详情查看StudentMapperTest.java中的testSelectStudentAndClassInfo方法

#### 一条sql语句, association

详情查看StudentMapperTest.java中的testSelectByIdAssociation方法

#### 多条sql语句, 分部查询(最常用, 优点1. 可复用, 优点2. 懒加载)

详情查看StudentMapperTest.java中的testSelectByMiltiSteps方法

1. 可复用, 一个大步分成多个小步,每个小步都可被重复利用
2. 充分利用他们的延迟加载/懒加载机制
   1. 延迟加载的核心原理:用的时候执行查询语句,不用的时候不查询
      1. 在本例中,如果我开启了懒加载,如果我只访问student的sname和/或sid属性,只有step1的sql语句被执行,只有当我访问了student的clazz属性时,第二条语句才会被执行
   2. 在association标签中添加`fetchType="lazy"`开启懒加载,这种配置只在当前resultMap中起作用
   3. 要想懒加载全局起作用,需要在`settings`配置段中开启`lazyLoadingEnabled`
   4. **实际开发中大部分需要延迟加载,所以建议开启全局延迟加载机制, 比如实际项目中学生可能跟班级/学科/成绩/父母信息等等关联,我们可以在POJO对象中把所有这些对象作为一个属性放到学生类中,然后在分步查询中把所有查询像一棵树一样堆起来, 调用这条sql语句查询仅仅我用得到的信息就很方便了**


## 一对多(一个班级对应多个学生, 本例着重构建Clazz对象)

```
通常使用集合表示一对多

public class Clazz{
    //.......
    private List<Student> stus;
}

public class Student{
    //.......
    private Clazz clazz;
}
```

#### 第一种实现方式 collection(不常用,了解一下)

具体查看ClazzMapperTest.java中的selectByCollection方法

#### 第二种实现方式 分步查询(最常用)

查看ClazzMapperTest.java中的testSelectByMiltiSteps方法

## 多对多

练习: 查询所有班级以及对应班级下的学生






