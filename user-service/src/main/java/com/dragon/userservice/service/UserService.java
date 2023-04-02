package com.dragon.userservice.service;

import com.dragon.userservice.mapper.UserRepository;
import com.dragon.userservice.pojo.User;
import com.mongodb.client.result.UpdateResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private MongoTemplate mongoTemplate;

    public void saveUser(User user) {
        userRepository.save(user);
    }

    public void updateUser(User user) {
        userRepository.save(user);
    }

    public void deletedUser(String id) {
        userRepository.deleteById(id);
    }

    public User findUserById(String id) {
        return userRepository.findById(id).get();
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public Page<User> findUserListByUserid(Integer userid, int page, int size) {
        return userRepository.findByUserid(userid, PageRequest.of(page-1, size));
    }

    public UpdateResult updateUserUserid(String id){
        Query query = Query.query(Criteria.where("_id").is(id));
        Update update = new Update();
        update.inc("userid");
        return mongoTemplate.updateFirst(query, update, User.class);
    }


}
