package com.poc.messageboard.custom;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Swaroop Pallapothu on Oct, 2019
 */
public enum Status {

    @JsonProperty("ACTIVE")
    ACTIVE(1, "Active"),
    @JsonProperty("RETIRED")
    RETIRED(2, "Retired"),
    @JsonProperty("INACTIVE")
    INACTIVE(3, "In Active");

    Status(int id, String name) {
        this.id = id;
        this.name = name;
    }

    int id;
    String name;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public static Status fromStatus(int id) {
        Status status;
        switch (id) {
            case 1:
                status = Status.ACTIVE;
                break;
            case 2:
                status = Status.RETIRED;
                break;
            case 3:
                status = Status.INACTIVE;
                break;
            default:
                status = Status.ACTIVE;
        }
        return status;
    }
}
