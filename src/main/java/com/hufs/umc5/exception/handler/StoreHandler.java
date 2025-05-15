package com.hufs.umc5.exception.handler;

import com.hufs.umc5.apiPayload.code.BaseErrorCode;
import com.hufs.umc5.exception.GeneralException;

public class StoreHandler extends GeneralException{
    public StoreHandler(BaseErrorCode errorCode) {super(errorCode);}
}


