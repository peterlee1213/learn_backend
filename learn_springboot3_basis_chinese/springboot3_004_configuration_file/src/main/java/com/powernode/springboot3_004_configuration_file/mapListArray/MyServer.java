package com.powernode.springboot3_004_configuration_file.mapListArray;

public class MyServer {
    private String title;
    private String ip;

    public MyServer(String title, String ip) {
        this.title = title;
        this.ip = ip;
    }

    public MyServer() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    @Override
    public String toString() {
        return "MyServer [title=" + title + ", ip=" + ip + "]";
    }

}
