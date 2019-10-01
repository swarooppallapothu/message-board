package com.poc.messageboard.repository;

import com.poc.messageboard.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * Created by Swaroop Pallapothu on Oct, 2019
 */
@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
}
