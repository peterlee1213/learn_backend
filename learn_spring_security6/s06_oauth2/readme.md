[oauth2.0的四种授权方式 - 阮一峰](https://www.ruanyifeng.com/blog/2019/04/oauth-grant-types.html)

# 四种授权模式

## 授权码模式
常见于第三方登陆，比如微信登陆,以github为例：
1. 首先开发者要去github开发者平台注册一个clientId和clientSecret
2. 用户要登陆我这个平台时我拿着我的clientId和clientSecret去github要针这个用户的授权码
3. 跳转到github之后，用户点击同意授权，github就会将授权码给应用程序
4. 应用程序就会拿着这个授权码去找github所要access-token

## 隐藏模式
相比授权码模式少了一个授权码，而是直接获取access-token
适用于没有后端的程序，不常用

## 密码模式
输入用户名和密码获取token，最常见的模式

## 凭证式
适用于没有前端的命令行应用，客户应用给出令牌或凭证，授权服务器给token
比如git通过密钥访问github

# OAuth2中的角色

1. 资源拥有者（Resource Owner），比如拥有用户名和密码的用户
2. 客户应用（Client），比如cloudflare这种需要访问github代码来CICD的程序,需要`OAuth2 client`依赖
3. 资源服务器（Resource Server），比如github服务器等存储着我的数据的服务器，需要`OAuth2 Resource Server`依赖
4. 授权服务器（Authorization Server），需要`OAuth2 Authorization Server`依赖

