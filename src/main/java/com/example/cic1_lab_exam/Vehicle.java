package com.example.cic1_lab_exam;

import jakarta.validation.constraints.*;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Vehicle {
    @NotBlank
    private String driverName;

    @Pattern(regexp = "[0-9]{2,3}-[A-Z]{1,2}-[0,9]{1,6}")
    private String regNumber;

    @Email
    private String email;

    @Min(1)@Max(8)
    private int passengers;

    public Vehicle(String driverName, String regNumber, String email, int passengers) {
        this.driverName = driverName;
        this.regNumber = regNumber;
        this.email = email;
        this.passengers = passengers;
    }

    public Vehicle() {
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getRegNumber() {
        return regNumber;
    }

    public void setRegNumber(String regNumber) {
        this.regNumber = regNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPassengers() {
        return passengers;
    }

    public void setPassengers(int passengers) {
        this.passengers = passengers;
    }
}
