package com.safenet.fxchangebe.repositories;

import com.safenet.fxchangebe.entities.Role;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends MongoRepository<Role,Integer> {
    public Role findByName(String name);
}
