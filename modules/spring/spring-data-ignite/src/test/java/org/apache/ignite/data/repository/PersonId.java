package org.apache.ignite.data.repository;

import org.springframework.data.annotation.Id;

public class PersonId {
    private Long id;
    private String name;

    public PersonId(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
    }
}
