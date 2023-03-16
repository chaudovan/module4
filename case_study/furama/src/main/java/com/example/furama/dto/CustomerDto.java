package com.example.furama.dto;

import com.example.furama.model.CustomerType;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Year;
import java.util.Date;

public class CustomerDto implements Validator {
    private int id;
    @NotBlank(message = "Không được để trống")
//    @Pattern(message = "Sai định dạng (VD: Nguyễn Văn A)", regexp = "^([A-Z\\p{L}]{1}[a-z\\p{L}]*)+(\\s([A-Z\\p{L}]{1}[a-z\\p{L}]*))*$")
    private String name;
    @NotEmpty
    private String dateOfBirth;
    @NotEmpty
    @Pattern(regexp = "^\\d{9}$",message = "sai dịnh dạng,id card gồm 9 số")
    private String idCard;
    private int gender;
    @NotEmpty
    private String phone;
    @NotEmpty
    @Pattern(regexp = "^[a-z]+([\\_\\.]?[a-z\\d]+)*@[a-z]{3,7}\\.[a-z]{3}$",message = "Email không đúng định dạng")
    private String email;
    @NotEmpty
    private String address;
    private CustomerType customerType;

    public CustomerDto() {
    }

    public CustomerDto(String name, String dateOfBirth, String idCard, int gender, String phone, String email, String address, CustomerType customerType) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.idCard = idCard;
        this.gender = gender;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.customerType = customerType;
    }

    public CustomerDto(int id, String name, String dateOfBirth, String idCard, String phone, String email, String address, CustomerType customerType) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.idCard = idCard;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.customerType = customerType;
    }

    public CustomerDto(int id, String name, String dateOfBirth, String idCard, int gender, String phone, String email, String address, CustomerType customerType) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.idCard = idCard;
        this.gender = gender;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.customerType = customerType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        CustomerDto customerDto = (CustomerDto) target;
        String name = customerDto.getName();
        if (!name.matches("^([A-Z\\p{L}]{1}[a-z\\p{L}]*)+(\\s([A-Z\\p{L}]{1}[a-z\\p{L}]*))*$")) {
            errors.rejectValue("name", null, "Tên không được chứa sổ chỉ chứa kí tự,và  chữ cái đầu phải viets hoa");
        }
        String phone = customerDto.getPhone();
        String regexPhone = "^(090|091|\\(\\+84\\)90|\\(\\+84\\)91)\\d{7}$";
        if (!phone.matches(regexPhone)) {
            errors.rejectValue("phone", null, "sai định dạng sdt,định dạng dungd 090|091|(84)+90|(84)+91 và bao gồm 10 số");
        }
        String dateOfBirth = customerDto.getDateOfBirth();
        System.out.println(dateOfBirth);
        LocalDate now = LocalDate.now();
        LocalDate date = LocalDate.parse(dateOfBirth);
        if (now.getYear() - date.getYear() < 18) {
            errors.rejectValue("dateOfBirth", null, "tuổi lớn hơn 18");
        }

    }
}
