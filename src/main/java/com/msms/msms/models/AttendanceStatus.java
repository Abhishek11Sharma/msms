package com.msms.msms.models;

import com.fasterxml.jackson.annotation.JsonValue;

public enum AttendanceStatus {
    PRESENT("P"),
    ABSENT("A"),
    DEFAULT("D");

    private final String code;

    AttendanceStatus(String code) {
        this.code = code;
    }

    @JsonValue
    public String getCode() {
        return code;
    }

    @Override
    public String toString() {
        return code;
    }
}