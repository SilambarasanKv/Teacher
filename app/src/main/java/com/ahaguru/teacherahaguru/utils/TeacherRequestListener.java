package com.ahaguru.teacherahaguru.utils;

import com.ahaguru.teacherahaguru.Entity.Teachers;

public interface TeacherRequestListener {
    void onApprove(Teachers teacher);
    void onReject(Teachers teacher);
}