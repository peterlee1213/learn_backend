package com.example.jpa_09_related_query.domains;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity(name = "tb_customer")
public class Customer {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "cust_address")
    private String custAddress;

    @Column(name = "cust_name")
    private String custName;

    /**
     * 单向关联一对一
     * cascade参数设置关联操作
     * 1.PERSIST表示插入会执行关联操作，即如果newCustomer对象中含有account对象，此时插入customer会让account跟着一起插入，并且account_id会随着更新
     * 2.All表示所有持久化操作都会执行关联操作
     * 3.MERGE表示修改会执行关联操作
     * 4.REMOVE表示删除会执行关联操作
     * 
     * 默认fetch = FetchType.EAGER,表示立即执行关联查询
     * fetch = FetchType.LAZY,表示执行懒加载，即用到了才会关联查询，否则不执行关联查询,因为不是所有的关联对象在任何时候都用得到
     * 为什么懒加载要在Controller上配置事务？
     * 当通过repository调用完查询方法，session立即关闭，就不能再查询了
     * 加了事务之后就能让session直到事务方法 执行完毕后才会关闭
     * 
     * orphanRemoval默认值为false,此时如果我修改account=null，对应的Account对象仍在数据库中没被删除
     * orphanRemoval设置为true表示如果我修改account=null,不光account_id设置为null或修改为其他关联数据,对应Account对象也从数据库中删除
     * 
     * optional默认值为true,表示关联对象可以为null，false则相反
     */
    @OneToOne(cascade = { CascadeType.PERSIST,
            CascadeType.REMOVE }, fetch = FetchType.EAGER, orphanRemoval = true, optional = false)
    @JoinColumn(name = "account_id") // 声明通过哪个id来join另外一个表
    private Account account;
}
