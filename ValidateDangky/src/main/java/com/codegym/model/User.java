package com.codegym.model;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import javax.persistence.*;
import javax.validation.constraints.*;
@Component
@Entity
@Table(name = "users")
public class User  {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Size(min = 5,max = 45,message = "Khong duoc de trong,Do dai tu 5 den 45")
    @NotEmpty
    private String firstName;
    @Size(min = 5,max = 45)
    @NotEmpty
    private String lastName;
    @Pattern(regexp = "^0[98]{1}\\d{9}$",message = "Sai dinh dang ")
    private String phoneNumber;
    @Min(value = 18, message = "Tuoi it nhat la 18")
    @Max(value = 150, message = "Tuoi nhieu nhat la 150")
    private int age;
    @Pattern(regexp = "^[a-zA-Z]+[a-zA-Z0-9]*@{1}[a-zA-Z]+mail.com$",message = "Sai dinh dang email")
    @NotEmpty(message = "Email khong duoc de trong")
    private String email;



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

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

//    @Override
//    public boolean supports(Class<?> clazz) {
//        return User.class.isAssignableFrom(clazz);
//    }
//
//    @Override
//    public void validate(Object target, Errors errors) {
//       User user=(User) target;
//       String phoneNumber=user.getPhoneNumber();
//        ValidationUtils.rejectIfEmpty(errors,"number","number.empty");
//        if(phoneNumber.length()<10 || phoneNumber.length()>11){
//            errors.rejectValue("number","number.lenght");
//        }
//        if (phoneNumber.startsWith("0")){
//            errors.rejectValue("number","number.startsWith");
//        }
//        if (phoneNumber.matches("(^$|[0-9]*$)")){
//            errors.rejectValue("number","number.matches");
//        }
//    }
}
