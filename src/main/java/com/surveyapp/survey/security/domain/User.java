package com.surveyapp.survey.security.domain;

import com.surveyapp.survey.domain.entities.product.BaseEntity;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Table(
        name = "user",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"email"}),
                @UniqueConstraint(columnNames = {"username"})
        })
@NoArgsConstructor
public class User extends BaseEntity {

    @NotBlank
    @NotNull
    @Size(min = 1, max=50)
    private String username;

    @NotBlank
    @NotNull
    @Email
    @Size(max=50)
    private String email;

    @EqualsAndHashCode.Exclude
    @NotBlank
    @NotNull
    @Size(min = 5)
    private String password;

    @EqualsAndHashCode.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="role_id", referencedColumnName = "ID")
    private Role role;

    @EqualsAndHashCode.Exclude
    @OneToMany(
            mappedBy = "user",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private Set<PasswordResetToken> passwordResetTokens;

    public User(String username, String email, String password, Role role) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public Role getRole() {
        return role;
    }
}
