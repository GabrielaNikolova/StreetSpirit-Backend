package com.app.streetspiritbackend.models.entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@MappedSuperclass
public abstract class BaseEntity {
    private String id;

    public BaseEntity() {
    }

    @Id
    @GeneratedValue(generator = "uuid-string")
    @GenericGenerator(name = "uuid-string", strategy = "org.hibernate.id.UUIDGenerator")
    @Column
    public String getId() {
        return id;
    }
    
    public BaseEntity setId(String id) {
        this.id = id;
        return this;
    }

}
