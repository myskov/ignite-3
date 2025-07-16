package org.apache.ignite.data.repository;

import org.jspecify.annotations.Nullable;
import org.springframework.data.annotation.Id;
import org.springframework.data.domain.Persistable;

public class PersonWithCompositeKey implements Persistable<PersonId> {
    @Id
    private PersonId personId;

    private Long age;

    public PersonWithCompositeKey() {}

    public PersonWithCompositeKey(PersonId personId, Long age) {
        this.personId = personId;
        this.age = age;
    }

    public PersonId getPersonId() {
        return personId;
    }

    public void setPersonId(PersonId id) {
        this.personId = id;
    }

    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
        this.age = age;
    }

    @Override
    public @Nullable PersonId getId() {
        return personId;
    }

    @Override
    public boolean isNew() {
        return true;
    }
}
