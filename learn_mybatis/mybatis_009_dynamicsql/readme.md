什么是dynamic sql

比如我获取没有过滤的列表时sql是这样的: select * from t_car
有一个过滤参数时是这样: select * from t_car where brand like "..."
有两个过滤参数时时这样: select * from t_car where brand like "..." and age < ...等等
sql语句是动态构建的

---

if 标签
为了多个if条件语句都可顺利拼接上, 格式应当如下:
```
    <select id="selectByIfFilter" resultType="car"> 
        select * from t_car where 1=1
        
        <if test="brand != null and brand != ''">
            and brand like "%"#{brand}"%"
        </if>
        <if test="guidePrice != null and guidePrice != ''">
            and guide_price > #{guidePrice}
        </if>
        <if test="carType != null and carType != ''">
            and car_type = #{carType}
        </if>
    </select>
```

这样不管拼接几个条件语句,或者即使一个条件都没有也没问题

---

where 标签
作用:
1. 所有条件都为空时, where标签保证不会生成where子句
2. 自动去除某些条件**前面**多余的and或or, **不能去掉后面的**

```
<select id="selectByIfFilterWithWhere" resultType="car">
    select * from t_car 
    <where>
        <if test="brand != null and brand != ''"> and brand like "%"#{brand}"%" </if>
        <if test="guidePrice != null and guidePrice != ''"> and guide_price > #{guidePrice} </if>
        <if test="carType != null and carType != ''"> and car_type = #{carType} </if>
    </where>
</select>
```

---

trim标签

```
<select id="selectByIfFilterWithTrim" resultType="car"> 
    select * from t_car 

    <!-- 
        prefix 加前缀
        suffix 加后缀
        prefixOverrides 删除前缀
        suffixOverrides 删除后缀
    -->
    <!-- prefix="where"表示在trim标签内部所有内容前面加where,如果trim标签内部没有内容输出则不输出where -->
    <!-- suffixOverrides="and|or"表示把trim标签中内容的多余的后缀and|or去掉 -->
    <trim prefix="where" suffixOverrides="and|or">
        <if test="brand != null and brand != ''"> brand like "%"#{brand}"%" and </if>
        <if test="guidePrice != null and guidePrice != ''"> guide_price > #{guidePrice} and </if>
        <if test="carType != null and carType != ''"> car_type = #{carType} and </if>
    </trim>
</select>
```
相对where标签的优势不过是可以动态除去if标签后面的and或者or

---

set标签

作用:
1. 在update语句中生成set关键字, 同时动态去掉最后多余的","
2. 只更新提交的不为空的字段,如果提交的数据是空或者"",那么这个字段不更新

