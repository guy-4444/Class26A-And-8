package com.guy.class26a_and_8;

public class Avatar {

    private String id;
    private String name;
    private String desc;

    public Avatar() {}

    public Avatar(String id, String name, String desc) {
        this.id = id;
        this.name = name;
        this.desc = desc;
    }

    public String getId() {
        return id;
    }

    public Avatar setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Avatar setName(String name) {
        this.name = name;
        return this;
    }

    public String getDesc() {
        return desc;
    }

    public Avatar setDesc(String desc) {
        this.desc = desc;
        return this;
    }
}
