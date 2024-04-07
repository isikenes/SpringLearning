package com.isikenes.mvcvalidation.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CountryCodeValidator implements ConstraintValidator<CountryCode, String> {

    private String code;

    @Override
    public void initialize(CountryCode countryCode) {
        code = countryCode.value();
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if (s==null)
            return true;

        return s.toUpperCase().equals(s) && (s.length() == 2 || s.length() == 3);
    }
}
