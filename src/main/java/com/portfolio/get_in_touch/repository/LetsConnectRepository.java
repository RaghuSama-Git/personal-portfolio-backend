package com.portfolio.get_in_touch.repository;

import com.portfolio.get_in_touch.model.LetsConnect;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LetsConnectRepository extends MongoRepository<LetsConnect, String> {
}
