package com.example.s05_nimbus_jwt_spring_security_seperate_front_back.entities;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "sys_user")
public class SysUser {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "user_name", length = 64)
    private String userName;

    @Column(name = "nick_name", length = 64)
    private String nickName;

    @Column(name = "password", length = 64)
    private String password;

    @Column(name = "status")
    private Character status;

    @Column(name = "email", unique = true, length = 64)
    private String email;

    @Column(name = "phonenumber", unique = true, length = 32)
    private String phonenumber;

    @Column(name = "sex")
    private Character sex;

    @Column(name = "avatar", length = 128)
    private String avatar;

    @Column(name = "user_type")
    private Character userType;

    @Column(name = "create_by")
    private Long createBy;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_by")
    private Long updateBy;

    @Column(name = "update_time")
    private Date updateTime;

    @Column(name = "deleted")
    private Integer deleted;
}
