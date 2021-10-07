package com.ahaguru.teacherahaguru.data.Model;

public class RegisterProfileOutput {
    private int status;
    private String message;
    private DataOutput data;

    public RegisterProfileOutput(int status, String message, DataOutput data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
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


