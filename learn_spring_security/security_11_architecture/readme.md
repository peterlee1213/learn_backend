# spring security 工作流程

![image](./image/security-filter-chain.png)

任何请求抵达servlet之前要经过三个filter, filter 0 和 2 都可以自定义，1是spring security用的。在第二个filter中有spring security写好的SecurityFilterChain, 这个chain对所有请求有效，当然我也可以写自己的filter chain,只对特定路径生效，如下图所示

![image1](./image//security-filter-chain-1.png)

只要匹配到任何一个chain就不会继续往下匹配了，只要这个chain走过了spring security的检测就通过了

# Security Filters
每个SecurityFilterChain有若干个filters, 这些filter需要合理配置执行顺序，比如抵御攻击要在认证之前，认证要在授权之前

# 查看当前已加载的SecurityFilterChain中的SecurityFilter顺序
去测试程序，在22行加个断点就行了

# 自定义一个Security并且添加到特定位置
