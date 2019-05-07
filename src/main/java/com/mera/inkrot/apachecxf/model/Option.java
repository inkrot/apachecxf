package com.mera.inkrot.apachecxf.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "options")
public class Option extends BaseEntity {

    private String name;

    //@ManyToMany(mappedBy = "options", fetch = FetchType.LAZY)
    //private Set<Order> orders = new HashSet<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
