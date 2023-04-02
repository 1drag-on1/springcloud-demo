package com.dragon.userservice.mapper;

import com.dragon.userservice.pojo.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {

    Page<User> findByUserid(Integer userid, Pageable pageable);

}
