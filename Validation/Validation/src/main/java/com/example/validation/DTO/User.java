package com.example.validation.DTO;

import com.example.validation.Annotation.yearmonth;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.Valid;
import javax.validation.constraints.*;
import javax.validation.constraintvalidation.SupportedValidationTarget;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class User {

    @NotBlank
    private String name;

    @Max(value = 90)
    private int age;

    @Valid // Car클래스도 공백 검증이 필요하므로 Valid어노테이션을 넣어준다.
    private List<Car> cars;

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    @yearmonth//(pattern = yyyyMM) 아니면 직접 만든거에서 default yyyyMM으로 하면 됨
    private String reqYearMonth; // YYYYMM

    public String getReqYearMonth() {
        return reqYearMonth;
    }

    public void setReqYearMonth(String reqYearMonth) {
        this.reqYearMonth = reqYearMonth;
    }


    @NotBlank
    private String email;

    @Pattern(regexp = "^\\d{2,3}-\\d{3,4}-\\d{4}$", message = "핸드폰 번호의 양식이 맞지 않습니다"/*message : 에러 메시지 수정*/)
    private String Phone;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", cars=" + cars +
                ", reqYearMonth='" + reqYearMonth + '\'' +
                ", email='" + email + '\'' +
                ", Phone='" + Phone + '\'' +
                '}';
    }
}
