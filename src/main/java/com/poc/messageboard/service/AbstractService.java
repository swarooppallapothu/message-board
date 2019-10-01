package com.poc.messageboard.service;

import java.util.List;
import java.util.UUID;

/**
 * Created by Swaroop Pallapothu on Oct, 2019
 */
public interface AbstractService<T> {

    T get(UUID id);

    List<T> getAll();

    void saveOrUpdate(T entity);

    void delete(UUID id);

}
