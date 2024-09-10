package com.example.jpa_09_related_query.domains;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
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
@Entity(name = "tb_student_class")
public class StudentClass {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    /**
     * 这是一个一对多的例子，关联关系声明在一的这边，即这个class中
     * 在student_class表中虽然没有指向student表id的外键,但是应该在这里声明关联字段
     * Student类型就相当于定义了哪个表，JoinColumn的name属性相当于定义了字段，映射关系就很清晰了
     * 
     * 同样的级联增删改也要通过cascade属性启用
     */
    @OneToMany(cascade = { CascadeType.ALL })
    @JoinColumn(name = "student_class_id")
    private List<Student> students;
}
