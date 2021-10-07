package com.ahaguru.teacherahaguru.data.Model;

public class RegisterProfileOutput {
    private Integer status;
    private String message;
    private DataOutput data;

    public RegisterProfileOutput(Integer status, String message, DataOutput data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public DataOutput getData() {
        return data;
    }

    public void setData(DataOutput data) {
        this.data = data;
    }
}


