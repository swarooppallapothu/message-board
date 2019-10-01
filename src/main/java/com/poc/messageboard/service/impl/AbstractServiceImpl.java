package com.poc.messageboard.service.impl;

import com.poc.messageboard.service.AbstractService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Created by Swaroop Pallapothu on Oct, 2019
 */
public class AbstractServiceImpl<T> implements AbstractService<T> {

    JpaRepository<T, UUID> repository;

    public AbstractServiceImpl(JpaRepository repository) {
        this.repository = repository;
    }

    public T get(UUID id) {
        Optional<T> entity = repository.findById(id);
        return entity.isPresent() ? entity.get() : null;
    }

    @Override
    public List<T> getAll() {
        return repository.findAll();
    }

    public List<T> get(List<UUID> ids) {
        return repository.findAllById(ids);
    }

    @Transactional
    public void saveOrUpdate(T entity) {
        repository.save(entity);
    }

    @Transactional
    public void delete(UUID id) {
        repository.deleteById(id);
    }

}