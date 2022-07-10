package com.mycompany.ems.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@NoArgsConstructor
@Entity
public class Login {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int loginID;
    private String username;
    private String password;
    private String role;

    private int empID;

    @OneToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "empID", insertable = false, updatable = false)
    private Employee employee;


    public Login(String username, String password ,String role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }


}
