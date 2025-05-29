package com.hufs.umc5.exception.handler;

import com.hufs.umc5.apiPayload.code.BaseErrorCode;
import com.hufs.umc5.exception.GeneralException;

public class MemberHandler extends GeneralException {
    public MemberHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}