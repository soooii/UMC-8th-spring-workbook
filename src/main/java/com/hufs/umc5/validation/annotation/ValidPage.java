package com.hufs.umc5.validation.annotation;

import com.hufs.umc5.validation.validator.CategoriesExistValidator;
import com.hufs.umc5.validation.validator.PageValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = PageValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER }) //어노테이션 적용 범위
@Retention(RetentionPolicy.RUNTIME) // 어노테이션 생명 주기 지정, 현재 실행 중(RUNTIME)에만 유효
public @interface ValidPage {

    String message() default "Page 범위가 0보다 커야합니다.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}