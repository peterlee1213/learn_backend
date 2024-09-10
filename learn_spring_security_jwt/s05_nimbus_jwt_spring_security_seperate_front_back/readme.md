1. 使用 jwt 代替 spring security 内置的 JSESSIONID
   1. 登陆成功颁发 jwt 而非 JSESSIONID
   2. 只要距离上次证书颁发时间超过 5 分钟就自动刷新（想一下怎么实现）
2. 在 AuthorizationFilter 之前添加一个自定义 Filter,将用户信息中的 Authentication 对象提取出来交给后面的 AuthorizationFilter 进行授权处理
