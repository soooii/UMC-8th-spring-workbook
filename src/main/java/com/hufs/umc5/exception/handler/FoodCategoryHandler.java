package com.hufs.umc5.exception.handler;

import com.hufs.umc5.apiPayload.code.BaseErrorCode;
import com.hufs.umc5.exception.GeneralException;

public class FoodCategoryHandler extends GeneralException {
    public FoodCategoryHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
