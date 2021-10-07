package com.ahaguru.teacherahaguru.data.Model;

import java.util.ArrayList;
import java.util.List;

public class TeacherOutput {

    private Integer teacherId;
    private String name;
    private Integer phone;
    private String email;
    private String communicationEmail;
    private List<String> subjects = new ArrayList<String>();
    private String teacherStatus;
    private School school;

    public TeacherOutput(Integer teacherId, String name, Integer phone, String email, String communicationEmail, List<String> subjects, String teacherStatus, School school) {
        this.teacherId = teacherId;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.communicationEmail = communicationEmail;
        this.subjects = subjects;
        this.teacherStatus = teacherStatus;
        this.school = school;
    }

    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCommunicationEmail() {
        return communicationEmail;
    }

    public void setCommunicationEmail(String communicationEmail) {
        this.communicationEmail = communicationEmail;
    }

    public List<String> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<String> subjects) {
        this.subjects = subjects;
    }

    public String getTeacherStatus() {
        return teacherStatus;
    }

    public void setTeacherStatus(String teacherStatus) {
        this.teacherStatus = teacherStatus;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }
}
