缺点：
1. 不支持嵌套或分组的属性约束，如firstname = ?1 or (firstname = ?2 and lastname = ?3)
2. 只支持字符串，start/contains/ends/regex 匹配和其他属性类型的精确匹配