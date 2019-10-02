package com.poc.messageboard.service;

import com.poc.messageboard.model.Message;

import java.util.List;
import java.util.UUID;

/**
 * Created by Swaroop Pallapothu on Oct, 2019
 */
public interface MessageService extends AbstractService<Message> {

    List<Message> getByCreatedUser(UUID userId);

}