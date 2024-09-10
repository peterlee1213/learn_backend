# 大体认证流程

![image1](./images/image1.png)

1. 用户通过请求发送过来的用户名和密码通过 UsernamePasswordAuthenticationToken 包装为一个简单的 Authentication 对象，这个对象只包括最基础的用户名和密码
2. 这个最简单的 Authentication 对象被扔给 AuthenticationManager 的实现类 ProviderManager,这个 ProviderManager 可能包括很多 AuthenticationProvider, 其中就有 DaoAuthenticationProvider
3. DaoAuthenticationProvider 调用 UserDetailsService 中的 loadUserByUsername 方法获取数据库或其他什么地方的用户信息
4. DaoAuthenticationProvider 通过注入找到 PasswordEncoder
5. ProviderManager 将步骤 1 中的 Authentication 对象以及 UserDetails 以及 PasswordEncoder 组合起来验证一下用户密码是否匹配，成功的话返回一个新的 Authentication 对象，这个对象包括用户的各种信息

# SecurityContextRepository

这是一个接口，主要负责用户认证之后的后续请求验证，比如颁发和维护和验证 JSESSIONID,JWT 等等

其默认实现类是 DelegatingSecurityContextRepository，它包含两个类

- HttpSessionSecurityContextRepository
- RequestAttributeSecurityContextRepository

## HttpSessionSecurityContextRepository

将 SecurityContext 和 HttpSession 关联起来，默认将 SecurityContext 和 JSESSIONID 关联起来
如果用户想用第三方库（比如 JWT），则可以用自定义的 SecurityContextRepository 实现类

## NullSecurityContextRepository

如果不希望将 SecurityContext 与 HttpSession 连接起来，比如不希望有 token 或者 SESSIONID 或者 JWT 等，可用这个
这是 SecurityContextRepository 的实现类，它什么都不做

## RequestAttributeSecurityContextRepository

RequestAttributeSecurityContextRepository 会在每一个已认证的用户的 ServletRequest 中加入当前用户的 SecurityContext,这样一来就用不着每个请求都需要手动写相同代码获取 SecurityContext 了
RequestAttributeSecurityContextRepository 这个类要自己写

```java
public SecurityFilterChain filterChain(HttpSecurity http) {
	http
		// ...
		.securityContext((securityContext) -> securityContext
			.securityContextRepository(new RequestAttributeSecurityContextRepository())
		);
	return http.build();
}
```
