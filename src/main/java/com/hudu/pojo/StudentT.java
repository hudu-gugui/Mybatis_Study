package com.hudu.pojo;

public class StudentT {
    private int sid;
    private String name;
    private int tid;

    public StudentT() {
    }

    public StudentT(int sid, String name, int tid) {
        this.sid = sid;
        this.name = name;
        this.tid = tid;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    @Override
    public String toString() {
        return "StudentT{" +
                "sid=" + sid +
                ", name='" + name + '\'' +
                ", tid=" + tid +
                '}';
    }
}
