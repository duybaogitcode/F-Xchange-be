package com.example.fxchangebe.repositories;

import com.example.fxchangebe.entities.Role;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends MongoRepository<Role,Integer> {
}
