https://www.youtube.com/watch?v=uZGuwX3St_c&t=111s

# JWT两种工作方式

1. 比如银行卡，卡中保存了我的ID,我还要输入我的密码，才能进行一系列操作，比如存钱取钱，此时我的具体信息是存储在数据库的
2. 比如公交卡，我买一张卡冲了钱之后钱数放在卡上，只要我确保这张卡不是伪造的就行了，具体信息存储在数据库中
# JWT由三段信息组成
```
xxxxxxxxxxxxx.xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.xxxxxxxxxxxxxxxxxx
```
1. 头部（header），第一段
   1. 相同的算法头部都是一致的
   2. 这只是一段JSON的base64编码，还不涉及加密
2. 载荷（payload），第二段
   1. 包含三部分
      1. 标准中注册的声明（建议但不强制使用）
         1. iss：jwt签发者
         2. sub：jwt面向的用户
         3. aud：接收jwt的一方
         4. exp：jwt过期时间，必须大于签发时间
         5. nbf：在什么时间之前该jwt都是不可用的
         6. iat：jwt签发时间
         7. jti：jwt唯一身份标志，主要用来作为一次性token,从而回避重放攻击
      2. 公共的声明
         1. 可添加任何信息，一般添加用户的相关信息或其他业务需要的信息，不应该添加敏感信息，因为该部分在客户端可解密
      3. 私有的声明
         1. 是提供者和消费者共同定义的声明，一般不建议存放敏感信息，因为base64是对称解密的，意味着这部分信息可归类为明文信息
3. 签证（signature），第三段
   1. 包含三部分
      1. header（base64后的）
      2. payload（base64后的）
      3. secret 也叫“盐/密钥”，保存在服务器端的，拿来进行jwt的签发和校验，这是服务器的私钥，任何情况下都不应该流露出去，否则任何人都可签发jwt了
   2. 第三段大概是这么来的：`HMACSHA256(base64UrlEncode(header) + '.' + base64UrlEncode(payload),'secret')`

# 工作机制
JWT的前两段都是一些json信息的base64编码的，都是明文的，最后一段对前面两段内容做校验，只要用同样的算法对前两段得出的digest跟第三段就说明这是一个合法的jwt,否则就是非法的jwt

密钥可以每次部署都重新随机生成，比如这样：
```bash
echo $(cat /proc/sys/kernel/random/uuid | sha256sum | cut -d' ' -f1)$(date +%s%N | sha256sum | cut -d' ' -f1 )$(cat /dev/urandom | head -n 20 | sha256sum | cut -d' ' -f1)
```