package com.safenet.fxchangebe.repositories;

import com.safenet.fxchangebe.entities.Tag;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagRepository extends MongoRepository<Tag, ObjectId> {
}
