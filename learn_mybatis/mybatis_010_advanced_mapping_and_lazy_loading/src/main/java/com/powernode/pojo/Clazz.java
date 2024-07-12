package com.powernode.pojo;

import java.util.List;

public class Clazz {
    private Long cid;
    private String cname;
    private List<Student> stus;

    public Clazz() {
    }

    public Clazz(Long cid, String cname, List<Student> stus) {
        this.cid = cid;
        this.cname = cname;
        this.stus = stus;
    }

    public Long getCid() {
        return cid;
    }

    public void setCid(Long cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    @Override
    public String toString() {
        return "Clazz [cid=" + cid + ", cname=" + cname + ", stus=" + stus + "]";
    }

    public List<Student> getStus() {
        return stus;
    }

    public void setStus(List<Student> stus) {
        this.stus = stus;
    }

}
