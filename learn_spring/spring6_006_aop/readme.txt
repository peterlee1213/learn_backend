通知有五种类型:
1. 前置通知@Before
2. 后置通知@AfterReturning
3. 环绕通知@Around
4. 异常通知@AfterThrowing
4. 最终通知@After

当有多个切面的时候,如何规定切面的顺序 
@Order(1)注解可规定顺序,数字越小优先级越高

通用切点:
解决的问题:同样的切点表达式要写多次
可通过@Pointcut注解定义通用切点表达式, 参考LogAspect, 如果跨java文件引用的话要写全限定名称, 参考SecurityAspect

在切面中获取切点
除了Around之外可用JoinPoint, Around可用ProceedingJoinPoint, 具体参照LogAspect

全注解式开发
加一个配置类,加上如下注解
@Configuration
@ComponentScan({ "com.powernode" })
@EnableAspectJAutoProxy

如何在一个切面中添加多个切点
使用@Pointcut定义多个通用切点, 然后再JoinPoint中通过||连接,参考下方图片
