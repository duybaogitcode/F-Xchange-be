package com.example.fxchangebe.repositories;

import com.example.fxchangebe.entities.PointHistory;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PointHistoryRepository extends MongoRepository<PointHistory, ObjectId> {
}
