package com.example.jpa_09_related_query.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.jpa_09_related_query.domains.Role;
import com.example.jpa_09_related_query.domains.User;
import com.example.jpa_09_related_query.repositories.RoleRepository;
import com.example.jpa_09_related_query.repositories.UserRepository;

import jakarta.annotation.Resource;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 使用User/Role
 */
@RestController
@RequestMapping("/9")
public class ManyToManyController {

    @Resource
    private UserRepository userRepository;

    @Resource
    private RoleRepository roleRepository;

    /**
     * 级联插入逻辑如下：
     * 1.如果我插入User时未指定roles,则只操作user
     * 2.如果我插入User时指定了一个或多个roles元素但这些roles元素有id，则除了插入user之外，还要插入user_role表
     * 3.如果我插入User时指定了一个或多个roles元素且这些rules元素没有id或指定id在role中不存在时，会直接报错
     */

    /**
     * 验证上述第一种逻辑
     */
    @GetMapping("/manytomanyinsert1")
    @Transactional
    public void insert1() {
        User user1 = new User();
        user1.setName("user1");
        userRepository.save(user1);
    }

    /**
     * 验证上述第二种逻辑
     * 
     * 一般情况下我们创建用户的时候都要从下拉框中选择
     */
    @GetMapping("/manytomanyinsert2")
    public void insert2() {

        Role role1 = new Role();
        role1.setId(1L);
        ArrayList<Role> arrayList = new ArrayList<Role>();
        arrayList.add(role1);

        User user2 = new User();
        user2.setName("user2");
        user2.setRoles(arrayList);
        userRepository.save(user2);
    }

    /**
     * 验证上述第三种逻辑
     */
    @GetMapping("/manytomanyinsert3")
    public void insert3() {

        Role role1 = new Role();
        role1.setId(3L);
        role1.setName("CEO");
        ArrayList<Role> arrayList = new ArrayList<Role>();
        arrayList.add(role1);

        User user2 = new User();
        user2.setName("user3");
        user2.setRoles(arrayList);
        userRepository.save(user2);
    }

    /**
     * 接下来插入role看看是否跟user行为完全对称
     * 1.如果我插入Role时未指定Users,则只操作role
     * 2.如果我插入Role时指定了一个或多个users元素但这些users元素有id，则除了插入role之外，还要插入user_role表
     */

    /**
     * 验证上述第一种逻辑
     */
    @GetMapping("/manytomanyinsert4")
    @Transactional
    public void insert4() {
        Role role = new Role();
        role.setName("CEO");
        roleRepository.save(role);
    }

    /**
     * 验证上述第二种逻辑
     * 必须得多对多映射的字段的annotation多对多双方都对等配置的情况下才生效
     */
    @GetMapping("/manytomanyinsert5")
    public void insert5() {

        User user = new User();
        user.setId(1L);

        ArrayList<User> arrayList = new ArrayList<User>();
        arrayList.add(user);

        Role role = new Role();
        role.setName("COO");
        role.setUsers(arrayList);

        roleRepository.save(role);
    }

    /**
     * 查询用户及其对应的角色
     */
    @GetMapping("manytomanyquery1")
    @Transactional(readOnly = true)
    public Optional<User> query1() {
        return userRepository.findItemById(2L);
    }

}
