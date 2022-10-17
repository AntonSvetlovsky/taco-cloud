package org.example.tacos.entity;

import lombok.Data;
import org.example.tacos.valid.ValidPassword;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@ValidPassword
public class RegistrationForm {

    @NotBlank(message = "Name is required")
    @Size(min = 4, message="Name must be at least 4 characters long")
    private String username;

    @NotBlank(message = "Password is required")
    @Size(min = 3, message="Password must be at least 3 characters long")
    @Size(max = 16, message="Password must be 16 characters long max")
    private String password;

    @NotBlank(message = "Password is required")
    @Size(min = 3, message="Password must be at least 3 characters long")
    @Size(max = 16, message="Password must be 16 characters long max")
    private String confirm;

    @NotBlank(message = "Full name is required")
    private String fullname;

    @NotBlank(message = "Street is required")
    private String street;

    @NotBlank(message = "City is required")
    private String city;

    @NotBlank(message = "State is required")
    private String state;

    @NotBlank(message = "Zip is required")
    private String zip;

    @NotBlank(message = "Phone number is required")
    private String phone;

    public User toUser(PasswordEncoder encoder) {
        return new User(
                username,
                encoder.encode(password),
                fullname,
                street,
                city,
                state,
                zip,
                phone);
    }
}
