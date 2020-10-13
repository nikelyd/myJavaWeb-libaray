package com.southwind.entity;

public class Reader {
    private int id;
    private String username;
    private String password;
    private String name;
    private int tel;
    private int cardId;
    private String gender;

    public Reader(String name, int tel, int cardid) {
        this.name = name;
        this.tel = tel;
        this.cardId = cardid;
    }

    public Reader(int id, String username, String password, String name, int tel, int cardid, String gender) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.name = name;
        this.tel = tel;
        this.cardId = cardid;
        this.gender = gender;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTel() {
        return tel;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }

    public int getCardId() {
        return cardId;
    }

    public void setCardId(int cardid) {
        this.cardId = cardid;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
