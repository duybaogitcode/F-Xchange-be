package com.example.fxchangebe.repositories;

import com.example.fxchangebe.entities.Permission;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PermissionRepository extends MongoRepository<Permission,Integer> {
}
