package com.gal.model;

import jakarta.persistence.*;

@Entity
public class ProjectManager {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long managerId;

    private String name;
    private String email;

    public ProjectManager() {}

    public ProjectManager(String name, String email) {
        this.name = name;
        this.email = email;
    }

    
}