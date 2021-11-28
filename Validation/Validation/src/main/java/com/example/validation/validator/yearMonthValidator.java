package com.example.validation.validator;

import com.example.validation.Annotation.yearmonth;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class yearMonthValidator implements ConstraintValidator<yearmonth, String> {
    //어노테이션에서 설정해준 클래스
    private String pattern;

    @Override
    public void initialize(yearmonth constraintAnnotation) {
        this.pattern = constraintAnnotation.pattern();
        //초기화
        //어노테이션에 지정된 패턴을 가져옴

    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        //yyyyMM
        System.out.println("ㅋㅋ "+value);
        try{
            LocalDate localDate = LocalDate.parse(value+"01"/*01은 그냥 디폴트로 붙임*/, DateTimeFormatter.ofPattern(this.pattern));
            //어노테이션에 지정한 패턴 형태로 value값이 잘 들어갔는지 확인하는 것
        }catch(Exception e){
            return false;
        }

        return true;

    }
}
