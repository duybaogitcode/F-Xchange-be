package com.example.fxchangebe.repositories;

import com.example.fxchangebe.entities.Notification;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationRepository extends MongoRepository<Notification, ObjectId> {
}
