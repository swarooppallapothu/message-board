package com.poc.messageboard.repository;

import com.poc.messageboard.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

/**
 * Created by Swaroop Pallapothu on Oct, 2019
 */
@Repository
public interface MessageRepository extends JpaRepository<Message, UUID> {

    List<Message> getByCreatedUserId(UUID userId);
}
