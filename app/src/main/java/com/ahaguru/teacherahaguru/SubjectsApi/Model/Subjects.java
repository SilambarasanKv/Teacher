package com.ahaguru.teacherahaguru.SubjectsApi.Model;

public class Subjects {

    String status;
    String message;
    String data;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public class Data {

        String supported_classes;
        String info_text;

        public String getSupported_classes() {
            return supported_classes;
        }

        public void setSupported_classes(String supported_classes) {
            this.supported_classes = supported_classes;
        }

        public String getInfo_text() {
            return info_text;
        }

        public void setInfo_text(String info_text) {
            this.info_text = info_text;
        }
    }

}
