# lombok用法

+ `@Getter`添加到POJO类上则会自动帮忙生成Get方法
+ 以此类推下面生成的是什么就不言而喻了
  + `@Setter`
  + `@NoArgsConstructor`
  + `@AllArgsConstructor`
  + `@ToString`
参照`domain/User.java`

`@Data`注解等同于`@Getter` + `@Setter` + `@ToString` + `@EqualsAndHashCode`

---

# `@Mapper`

加在`Mapper`的interface上，可以自动生成这个interface的代理对象,并将代理对象纳入spring容器管理（就是说可在其他地方进行注入操作）。并且会自动到对应的包下找同名的xml文件


