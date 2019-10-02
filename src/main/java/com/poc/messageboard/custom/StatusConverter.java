package com.poc.messageboard.custom;

import javax.persistence.AttributeConverter;

/**
 * Created by Swaroop Pallapothu on Oct, 2019
 */
public class StatusConverter implements AttributeConverter<Status, Integer> {

    @Override
    public Integer convertToDatabaseColumn(Status status) {
        if (status == null) {
            return null;
        }
        return status.getId();
    }

    @Override
    public Status convertToEntityAttribute(Integer integer) {
        if (integer == null) {
            return null;
        }
        return Status.fromStatus(integer);
    }

}