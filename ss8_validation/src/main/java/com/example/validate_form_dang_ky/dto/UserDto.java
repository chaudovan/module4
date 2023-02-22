package com.example.validate_form_dang_ky.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class UserDto implements Validator {
    private int id;
    @NotEmpty
    @Size(min = 5,max = 45,message = "first name min 5 and max 45")
    private String firstName;
    @NotEmpty
    @Size(min = 5,max = 45,message = "last name min 5 and max 45")
    private String lasttName;
    private String phoneNumber;
    @Min(value = 18,message = "age >18")
    private int age;
    @Email
    private String email;

    public UserDto() {
    }

    public UserDto(int id, String firstName, String lasttName, String phoneNumber, int age, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lasttName = lasttName;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLasttName() {
        return lasttName;
    }

    public void setLasttName(String lasttName) {
        this.lasttName = lasttName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
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

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserDto userDto = (UserDto) target;
        String phoneNumber = userDto.getPhoneNumber();
        if(!phoneNumber.matches("^\\d+$")){
            errors.rejectValue("phoneNumber",null,"SDT chỉ chứa ký tự số");
        }else if(phoneNumber.length()<10 && phoneNumber.length()>11){
            errors.rejectValue("phoneNumber",null,"SDT phải là 10 số");
        }
    }
}
