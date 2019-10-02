package com.poc.messageboard.service.impl;

import com.poc.messageboard.model.User;
import com.poc.messageboard.repository.UserRepository;
import com.poc.messageboard.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.Objects;

/**
 * Created by Swaroop Pallapothu on Oct, 2019
 */
@Service
public class UserServiceImpl extends AbstractServiceImpl<User> implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        super(userRepository);
        this.userRepository = userRepository;
    }

    @Override
    public void saveOrUpdate(User entity) {
        if (Objects.isNull(entity.getId())) {
            entity.setCreatedTimestamp(ZonedDateTime.now());
        }
        super.saveOrUpdate(entity);
    }
}