package com.ahaguru.teacherahaguru.data.Model;

import java.util.ArrayList;
import java.util.List;

public class TeacherInput {
    private String name;
    private String phone;
    private String emairegister_tl;
    private String subjects;
    private String teacher_status;
    private String communication_email;

    public TeacherInput(String name, String phone, String emairegister_tl, String subjects, String teacher_status, String communication_email) {
        this.name = name;
        this.phone = phone;
        this.emairegister_tl = emairegister_tl;
        this.subjects = subjects;
        this.teacher_status = teacher_status;
        this.communication_email = communication_email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmairegister_tl() {
        return emairegister_tl;
    }

    public void setEmairegister_tl(String emairegister_tl) {
        this.emairegister_tl = emairegister_tl;
    }

    public String getSubjects() {
        return subjects;
    }

    public void setSubjects(String subjects) {
        this.subjects = subjects;
    }

    public String getTeacher_status() {
        return teacher_status;
    }

    public void setTeacher_status(String teacher_status) {
        this.teacher_status = teacher_status;
    }

    public String getCommunication_email() {
        return communication_email;
    }

    public void setCommunication_email(String communication_email) {
        this.communication_email = communication_email;
    }
}
