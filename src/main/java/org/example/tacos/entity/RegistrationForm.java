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
    @Size(min = 4, message="Username must be at least 4 characters long")
    @Size(max = 32, message="Username must be 32 characters long max")
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
    @Size(min = 4, message="Full name must be at least 4 characters long")
    @Size(max = 32, message="Full name must be 32 characters long max")
    private String fullname;

    @NotBlank(message = "Street is required")
    @Size(min = 4, message="Street must be at least 4 characters long")
    @Size(max = 32, message="Street must be 32 characters long max")
    private String street;

    @NotBlank(message = "City is required")
    @Size(min = 2, message="City must be at least 2 characters long")
    @Size(max = 32, message="City must be 32 characters long max")
    private String city;

    @NotBlank(message = "State is required")
    @Size(min = 2, message="State must be 2 characters long")
    @Size(max = 2, message="State must be 2 characters long")
    private String state;

    @NotBlank(message = "Zip is required")
    @Size(min = 2, message="Zip code must be at least 2 characters long")
    @Size(max = 10, message="Zip code must be 10 characters long max")
    private String zip;

    @NotBlank(message = "Phone number is required")
    @Size(min = 3, message="Phone number must be at least 3 characters long")
    @Size(max = 16, message="Phone number must be 16 characters long max")
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
