## 什么是dynamic sql

比如我获取没有过滤的列表时sql是这样的: select * from t_car
有一个过滤参数时是这样: select * from t_car where brand like "..."
有两个过滤参数时时这样: select * from t_car where brand like "..." and age < ...等等
sql语句是动态构建的

---

## if 标签
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

## where 标签
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

## trim标签

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

## set标签

作用:
1. 在update语句中生成set关键字, 同时动态去掉最后多余的","
2. 只更新提交的不为空的字段,如果提交的数据是空或者"",那么这个字段不更新

```
    <update id="updateWithSet">
        update t_car
        <set>
            <if test="carNum != null and carNum != ''">
                car_num = #{carNum},
            </if>
            <if test="brand != null and brand != ''"> brand = #{brand},, </if>
            <if test="guidePrice != null and guidePrice != ''"> guide_price = #{guidePrice}, </if>
            <if test="produceTime != null and produceTime != ''"> produce_time = #{produceTime}, </if>
            <if test="carType != null and carType != ''"> car_type = #{carType}, </if>
        </set>
        where id = #{id}
    </update>
```

---

## choose when otherwise

其格式如下
```
<choose>
    <when></when>
    <when></when>
    <when></when>
    <when></when>
    <otherwise></otherwise>
</choose>
```
相当于switch case语句
choose -> switch
when -> case
otherwise -> default

## foreach

比如一次插入/删除多条记录场景会用到此标签

```
    <delete id="deleteByIds">
        delete from t_car where id in (
            <!-- 
                foreach标签的属性:
                    collection: 指定数组或集合
                    item: 代表数组或集合中的元素
                    separator: 循环之间的分隔符
                #{id}中的id是item属性的值
                最终这个foreach标签会变成将ids这个数组或集合的所有元素逗号分隔的字串
            -->
            <foreach collection="ids" item="id" separator=",">#{id}</foreach>
        )
    </delete>
```

小括号可以省略
```
    <delete id="deleteByIds">
        delete from t_car where id in 
        <foreach collection="ids" item="id" separator="," open="(" close=")">#{id}</foreach>
    </delete>
```

一次插入多条记录
```
<insert id="insertMultipleCars">
    insert into t_car values
    <foreach collection="cars" item="recordItem" separator=",">
        (null,#{recordItem.carNum},#{recordItem.brand},#{recordItem.guidePrice},#{recordItem.produceTime},#{recordItem.carType})
    </foreach>
</insert>
```

也可以使用where + foreach 进行批量删除, 具体看测试程序

## sql标签与include标签

sql标签用来声明sql片段
include标签用来将声明的片段插入到某个sql语句中

