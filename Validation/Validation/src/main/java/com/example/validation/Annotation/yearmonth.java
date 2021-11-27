package com.example.validation.Annotation;


import com.example.validation.validator.yearMonthValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.time.YearMonth;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.ElementType.TYPE_USE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Constraint(validatedBy = {yearMonthValidator.class})//클래스 이름 넣어줌
@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE })
@Retention(RUNTIME)
public @interface yearmonth {

    String message() default "{yyyyMM에 맞지 않습니다.}";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };


    String pattern() default "yyyyMMdd";
}
