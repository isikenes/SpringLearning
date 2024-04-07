package com.isikenes.mvcvalidation;

import com.isikenes.mvcvalidation.validation.CountryCode;
import jakarta.validation.constraints.*;

public class Customer {

    @NotNull(message = " is required")
    @Size(min = 1, message =" is required")
    private String firstName;
    private String lastName;

    @Min(value = 10, message = "must be greater than 10")
    @Max(value = 100, message = "are you eternal?")
    private Integer age;

    @Pattern(regexp = "^[0-9]{5}", message = "enter 5 digits")
    private String postalCode;

    @CountryCode()
    private String countryCode;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }
}
