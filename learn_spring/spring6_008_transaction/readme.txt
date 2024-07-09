最基本的事务管理参照com.powernode.bank

@Transactional的常用属性以及含义
1. propagation 事务的传递, A方法和B方法都有自己的事务或者某一个有事务,如果A调用B,spring应当如何处理事务,是合并还是一个加入另外一个等等
2. isolation 事务的隔离级别 
3. timeout 事务的超时时间
4. readOnly 事务是否是只读的(只有查询,没有增改查), 若事务是只读且设置readOnly为true, spring会优化查询速度
5. rollBackFor 当我的程序出现什么Exception时才回滚
6. noRollBackFor 出现哪些异常时不回滚