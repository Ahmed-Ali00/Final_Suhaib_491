package com.codingelab.tutorial;

public class Data_Provider {
    private String id;
    private String name;
    private String moblie;
    private  String email;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMoblie() {
        return moblie;
    }

    public void setMoblie(String moblie) {
        this.moblie = moblie;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Data_Provider(String id, String name, String moblie, String email)
    {

        this.id=id;
        this.name=name;
        this.moblie=moblie;
        this.email=email;
    }

    public Data_Provider(String name) {
        this.name = name;
    }
}
