package com.portfolio.get_in_touch.model;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Document(collection = "Lets_Connect")
public class LetsConnect {
    @MongoId
    private String id;
    private String name;
    private String email;
    private String subject;
    private String desc_message;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getDesc_message() {
        return desc_message;
    }

    public void setDesc_message(String desc_message) {
        this.desc_message = desc_message;
    }
}
