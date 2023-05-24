package com.safenet.fxchangebe.repositories;


import com.safenet.fxchangebe.entities.Comment;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends MongoRepository<Comment, ObjectId> {
    Comment findByStuffId(ObjectId stuffId);
}
