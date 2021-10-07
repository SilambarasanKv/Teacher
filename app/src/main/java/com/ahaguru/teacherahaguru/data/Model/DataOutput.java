package com.ahaguru.teacherahaguru.data.Model;

public class DataOutput {
    private Integer profileType;
    private TeacherOutput teacher;

    public DataOutput(Integer profileType, TeacherOutput teacher) {
        this.profileType = profileType;
        this.teacher = teacher;
    }

    public Integer getProfileType() {
        return profileType;
    }

    public void setProfileType(Integer profileType) {
        this.profileType = profileType;
    }

    public TeacherOutput getTeacher() {
        return teacher;
    }

    public void setTeacher(TeacherOutput teacher) {
        this.teacher = teacher;
    }
}
