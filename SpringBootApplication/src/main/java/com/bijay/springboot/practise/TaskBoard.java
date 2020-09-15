package com.bijay.springboot.practise;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigInteger;

@Document(collection = "TaskBoard")
public class TaskBoard {

    @Id
    private ObjectId _id;
    private String taskName;
    private String taskPoint;
    private String taskDetail;
    private String subTask;
    private String assignTo;

    public ObjectId get_id() {
        return _id;
    }

    public String getTaskName() {
        return taskName;
    }

    public String getTaskPoint() {
        return taskPoint;
    }

    public String getTaskDetail() {
        return taskDetail;
    }

    public String getSubTask() {
        return subTask;
    }

    public String getAssignTo() {
        return assignTo;
    }

}
