package com.hufs.umc5.web.annotation;

import com.hufs.umc5.validation.validator.PageValidator;
import jakarta.validation.Constraint;
import org.springframework.stereotype.Component;

import java.lang.annotation.*;

@Documented
@Target( ElementType.PARAMETER ) //어노테이션 적용 범위
@Retention(RetentionPolicy.RUNTIME)
public @interface MinusOnePage {
}
