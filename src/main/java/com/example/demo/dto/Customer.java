package com.example.demo.dto;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@Data
public class Customer {

    private String firstName;
    private String middleName;
    private String lastName;
    private String secondLastName;
    private String phone;
    private String address;
    private String cityOfResidence;

    public Customer() {
        this.firstName="Jhon";
        this.middleName="Michael";
        this.lastName="Doe";
        this.secondLastName="Smith";
        this.phone="+1-555-1234";
        this.address="1234 Elm Street, Apt 5B";
        this.cityOfResidence="New York";
    }
}
