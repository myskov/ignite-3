package org.apache.ignite.data.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonWithCompositeKeyRepository extends CrudRepository<PersonWithCompositeKey, PersonId> {
}
