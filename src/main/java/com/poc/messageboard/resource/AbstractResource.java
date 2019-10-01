package com.poc.messageboard.resource;

import com.poc.messageboard.dto.Response;
import com.poc.messageboard.service.AbstractService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/**
 * Created by Swaroop Pallapothu on Oct, 2019
 */
public abstract class AbstractResource<T> {

    public final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    private final AbstractService abstractService;

    public AbstractResource(AbstractService abstractService) {
        this.abstractService = abstractService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Response<T>> get(@PathVariable(name = "id") UUID id) {
        try {
            return ResponseEntity.ok(Response.<T>builder().result(Response.ResultCode.SUCCESS).data((T) abstractService.get(id)).build());
        } catch (Exception e) {
            LOGGER.error("Exception occurred in method get with id:" + id, e);
            return ResponseEntity.badRequest().body(Response.<T>builder().result(Response.ResultCode.ERROR).build());
        }
    }

    @GetMapping("/all")
    public ResponseEntity<Response<List<T>>> getAll() {
        try {
            return ResponseEntity.ok(Response.<List<T>>builder().result(Response.ResultCode.SUCCESS).data(abstractService.getAll()).build());
        } catch (Exception e) {
            LOGGER.error("Exception occurred in method getAll", e);
            return ResponseEntity.badRequest().body(Response.<List<T>>builder().result(Response.ResultCode.ERROR).build());
        }
    }

    @PostMapping
    public ResponseEntity<Response<T>> insert(@RequestBody T entity) {
        try {
            abstractService.saveOrUpdate(entity);
            return ResponseEntity.ok(Response.<T>builder().data(entity).result(Response.ResultCode.SUCCESS).build());
        } catch (Exception e) {
            LOGGER.error("Exception occurred in method insert", e);
            return ResponseEntity.badRequest().body(Response.<T>builder().result(Response.ResultCode.ERROR).build());
        }
    }

    @PutMapping
    public ResponseEntity<Response<T>> update(@RequestBody T entity) {
        try {
            abstractService.saveOrUpdate(entity);
            return ResponseEntity.ok(Response.<T>builder().data(entity).result(Response.ResultCode.SUCCESS).build());
        } catch (Exception e) {
            LOGGER.error("Exception occurred in method update", e);
            return ResponseEntity.badRequest().body(Response.<T>builder().result(Response.ResultCode.ERROR).build());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Response> delete(@PathVariable(name = "id") UUID id) {
        try {
            abstractService.delete(id);
            return ResponseEntity.ok(Response.builder().result(Response.ResultCode.SUCCESS).build());
        } catch (Exception e) {
            LOGGER.error("Exception occurred in method delete", e);
            return ResponseEntity.badRequest().body(Response.<T>builder().result(Response.ResultCode.ERROR).build());
        }
    }

}
