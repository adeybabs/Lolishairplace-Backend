package com.project.LolishairplaceBackend.model.user;

import com.project.LolishairplaceBackend.annotation.PasswordValueMatch;
import com.project.LolishairplaceBackend.annotation.ValidPassword;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.*;

@PasswordValueMatch.List({
        @PasswordValueMatch(
                field = "password",
                fieldMatch = "confirmPassword",
                message = "Passwords do not match!"
        )
})

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@Entity
@ToString
@AllArgsConstructor
public class AppUser implements UserDetails {

    @SequenceGenerator(
            name = "user_sequence",
            sequenceName = "user_sequence",
            allocationSize = 1
    )

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )

    private Long id;
    @NonNull
    @NotBlank(message = "Name is mandatory")
    private String firstName;

    private String lastName;

    @NotNull
    @NotEmpty
    @Email
    private String email;

    @ValidPassword
    @NonNull
    @NotBlank(message = "New password is mandatory")
    private String password;

    @ValidPassword
    @NonNull
    @NotBlank(message = "Confirm Password is mandatory")
    private String confirmPassword;

    @Enumerated(EnumType.STRING)
    private AppUserRole appUserRole;

}
