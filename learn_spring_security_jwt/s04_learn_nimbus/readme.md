nimbus 可以签发两种类型的 jwt：

1. JWS 签发 token，payload 是公开的，token 到达后只需要验证签名看下是否有 unauthorized modification 就可以了
2. JWE 签发 token,payload 是加密的，一般情况下配合 JWS 使用，先使用 JWS 进行签名，然后使用 JWE 进行加密，可同时确保数据的安全性和完整性

签发 jwt 示例（JWS）参照 testSignJWS 测试方法
验证 jwt 示例（JWS）参照 testDecodeJWS 测试方法
