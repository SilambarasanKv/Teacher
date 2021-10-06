package com.ahaguru.teacherahaguru.utils;

import com.ahaguru.teacherahaguru.data.Entity.Teachers;

public interface TeacherRequestListener {
    void onApprove(Teachers teacher);
    void onReject(Teachers teacher);
}