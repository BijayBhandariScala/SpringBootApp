package com.bijay.springboot.practise;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface TaskRepository extends MongoRepository<TaskBoard, ObjectId> {


}
