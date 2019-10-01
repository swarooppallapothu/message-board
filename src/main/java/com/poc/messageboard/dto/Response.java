package com.poc.messageboard.dto;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * Created by Swaroop Pallapothu on Oct, 2019
 */
@Data
@Builder
public class Response<T> implements Serializable {

    public enum ResultCode {
        SUCCESS, ERROR;

        ResultCode() {
        }
    }

    private ResultCode result;
    private T data;
    private String message = "";

}
