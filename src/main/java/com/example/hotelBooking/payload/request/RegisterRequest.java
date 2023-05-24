package com.example.hotelBooking.payload.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
    @NotBlank(message = "Name shouldn't be blank!")
    private String name;
    @NotBlank(message = "Email shouldn't be blank!")
    @Email(message = "Invalid email address!")
    private String email;
    @NotBlank(message = "Phone number shouldn't be blank!")
    @Pattern(regexp = "^\\d{10}$", message = "Invalid phone number!")
    private String phoneNumber;
    @NotBlank(message = "Username shouldn't be blank!")
    private String username;
    @NotBlank(message = "Password shouldn't be blank!")
    private String password;

    private Set<String> roles;
}
