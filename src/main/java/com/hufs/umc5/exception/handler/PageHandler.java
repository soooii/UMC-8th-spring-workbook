package com.hufs.umc5.exception.handler;

import com.hufs.umc5.apiPayload.code.BaseErrorCode;
import com.hufs.umc5.exception.GeneralException;

public class PageHandler extends GeneralException {
    public PageHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
