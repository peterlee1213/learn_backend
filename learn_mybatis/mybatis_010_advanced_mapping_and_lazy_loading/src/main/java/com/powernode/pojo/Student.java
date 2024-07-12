package com.powernode.pojo;

public class Student { // student是多的一方
    private Long sid;
    private String sname;
    private Clazz clazz; // clazz是一的一方

    public Student() {
    }

    public Student(Long sid, String sname, Clazz clazz) {
        this.sid = sid;
        this.sname = sname;
        this.clazz = clazz;
    }

    public Long getSid() {
        return sid;
    }

    public void setSid(Long sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public Clazz getClazz() {
        return clazz;
    }

    public void setClazz(Clazz clazz) {
        this.clazz = clazz;
    }

    @Override
    public String toString() {
        return "Student [sid=" + sid + ", sname=" + sname + ", clazz=" + clazz + "]";
    }

}
