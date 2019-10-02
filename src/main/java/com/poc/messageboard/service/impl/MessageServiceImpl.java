package com.poc.messageboard.service.impl;

import com.poc.messageboard.custom.Status;
import com.poc.messageboard.model.Message;
import com.poc.messageboard.repository.MessageRepository;
import com.poc.messageboard.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

/**
 * Created by Swaroop Pallapothu on Oct, 2019
 */
@Service
public class MessageServiceImpl extends AbstractServiceImpl<Message> implements MessageService {

    private final MessageRepository messageRepository;

    @Autowired
    public MessageServiceImpl(MessageRepository messageRepository) {
        super(messageRepository);
        this.messageRepository = messageRepository;
    }

    @Override
    public void saveOrUpdate(Message entity) {
        if (Objects.isNull(entity.getId())) {
            entity.setCreatedTimestamp(ZonedDateTime.now());
            entity.setStatus(Status.ACTIVE);
        } else {
            Message dbEntity = super.get(entity.getId());
            entity.setModifiedTimestamp(ZonedDateTime.now());
            entity.setCreatedTimestamp(dbEntity.getCreatedTimestamp());
            if (Objects.isNull(entity.getStatus())) {
                entity.setStatus(dbEntity.getStatus());
            }
        }
        super.saveOrUpdate(entity);
    }

    @Override
    public List<Message> getByCreatedUser(UUID userId) {
        return messageRepository.getByCreatedUserId(userId);
    }
}