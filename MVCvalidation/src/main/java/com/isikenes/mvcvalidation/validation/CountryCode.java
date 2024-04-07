package com.isikenes.mvcvalidation.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = CountryCodeValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CountryCode {
    public String value() default "TR";

    public String message() default "must be uppercase and 2 or 3 letters";

    public Class<?>[] groups() default {};

    public Class<? extends Payload>[] payload() default {};
}
