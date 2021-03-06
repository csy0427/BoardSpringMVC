package com.Domain;

import javax.persistence.*;

@Entity
@Table(name="member")
public class Member {

    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private String id;

    @Column(name="password")
    private String password;

    @Column(name="name")
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

}
