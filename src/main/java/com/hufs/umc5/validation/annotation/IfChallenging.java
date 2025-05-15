package com.hufs.umc5.validation.annotation;

import com.hufs.umc5.validation.validator.IfChallengingValidator;
import com.hufs.umc5.validation.validator.StoreExistValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = IfChallengingValidator.class)
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface IfChallenging {

    String message() default "ALLREADY_CHALLENGING";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
