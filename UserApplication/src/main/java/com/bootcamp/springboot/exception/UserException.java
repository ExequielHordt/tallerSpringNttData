package com.bootcamp.springboot.exception;


public class UserException {
    private final Class<?> type;
    private final String title;
    private final int status;
    private final String detail;

    public UserException(Class<?> type, String title, int status, String detail) {
        this.type = type;
        this.title = title;
        this.status = status;
        this.detail = detail;
    }

    public Class<?> getType() {
        return type;
    }

    public String getTitle() {
        return title;
    }

    public int getStatus() {
        return status;
    }

    public String getDetail() {
        return detail;
    }

}
