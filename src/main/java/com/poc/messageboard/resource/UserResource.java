package com.poc.messageboard.resource;

import com.poc.messageboard.model.User;
import com.poc.messageboard.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Swaroop Pallapothu on Oct, 2019
 */
@RestController
@RequestMapping(value = "/api/user")
public class UserResource extends AbstractResource<User> {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    private final UserService userService;

    public UserResource(UserService userService) {
        super(userService);
        this.userService = userService;
    }
}
