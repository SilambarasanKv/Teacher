package com.ahaguru.teacherahaguru.data.Model;

public class RegisterProfileInput {

    private int profile_type;
    private String school_teacher_code;
    private TeacherInput teacher;

    public RegisterProfileInput(int profile_type, String school_teacher_code, TeacherInput teacher) {
        this.profile_type = profile_type;
        this.school_teacher_code = school_teacher_code;
        this.teacher = teacher;
    }

    public int getProfile_type() {
        return profile_type;
    }

    public void setProfile_type(int profile_type) {
        this.profile_type = profile_type;
    }

    public String getSchool_teacher_code() {
        return school_teacher_code;
    }

    public void setSchool_teacher_code(String school_teacher_code) {
        this.school_teacher_code = school_teacher_code;
    }

    public TeacherInput getTeacher() {
        return teacher;
    }

    public void setTeacher(TeacherInput teacher) {
        this.teacher = teacher;
    }
}
