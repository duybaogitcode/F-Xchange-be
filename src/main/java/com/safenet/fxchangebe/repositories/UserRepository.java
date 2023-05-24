package com.safenet.fxchangebe.repositories;

import com.safenet.fxchangebe.entities.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User, ObjectId> {
    Optional<User> findByGoogleId(String googleId);

    void deleteByGoogleId(String googleId);
}
