package com.example.jpa_09_related_query.domains;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "tb_role")
public class Role {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToMany(fetch = FetchType.LAZY)
    // 中间表需要通过@JoinTable来维护外键，不设置也会自动生成
    @JoinTable(name = "tb_user_role", // 要连接的中间表的名称
            joinColumns = @JoinColumn(name = "role_id"), // 当前表主键连接到的中间表的外键的名称
            inverseJoinColumns = @JoinColumn(name = "user_id")) // 中间表中另外一边的表的外键名称
    private List<User> users;
}
