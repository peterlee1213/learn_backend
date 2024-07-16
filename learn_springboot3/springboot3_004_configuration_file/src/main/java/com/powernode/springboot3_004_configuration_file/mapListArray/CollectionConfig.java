package com.powernode.springboot3_004_configuration_file.mapListArray;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties
@Component("collectionConfig")
public class CollectionConfig {
    private List<MyServer> servers;
    private Map<String, User> users;
    private String[] names;

    public CollectionConfig() {
    }

    public CollectionConfig(List<MyServer> servers, Map<String, User> users, String[] names) {
        this.servers = servers;
        this.users = users;
        this.names = names;
    }

    public List<MyServer> getServers() {
        return servers;
    }

    public void setServers(List<MyServer> servers) {
        this.servers = servers;
    }

    public Map<String, User> getUsers() {
        return users;
    }

    public void setUsers(Map<String, User> users) {
        this.users = users;
    }

    public String[] getNames() {
        return names;
    }

    public void setNames(String[] names) {
        this.names = names;
    }

    @Override
    public String toString() {
        return "CollectionConfig [servers=" + servers + ", users=" + users + ", names=" + Arrays.toString(names) + "]";
    }

}
