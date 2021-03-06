package com.kaankilic.spring.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target({ElementType.TYPE, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {EqualPasswordImpl.class})
public @interface EqualPassword {
 
    String message() default "message";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
    
    String password();
 
}

