package com.hufs.umc5.validation.annotation;

import com.hufs.umc5.validation.validator.IfChallengingValidator;
import com.hufs.umc5.validation.validator.IfCompleteValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = IfCompleteValidator.class)
@Target({ ElementType.TYPE, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface IfComplete {

    String message() default "ALLREADY_COMPLETE";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}

