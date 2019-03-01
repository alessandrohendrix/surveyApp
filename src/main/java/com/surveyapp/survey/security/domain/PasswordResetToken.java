package com.surveyapp.survey.security.domain;

import com.surveyapp.survey.domain.product.BaseEntity;
import com.surveyapp.survey.utility.LocalDateTimeConverter;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class PasswordResetToken extends BaseEntity {

    @EqualsAndHashCode.Exclude
    @Column(unique = true)
    private String token;

    @EqualsAndHashCode.Exclude
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name="expiration_date")
    @Convert(converter = LocalDateTimeConverter.class)
    private LocalDateTime expirationDate;
    @Value("${token.expiration.length.minutes}")
    private int DEFAULT_TOKEN_LENGTH_IN_MINUTES;

    public PasswordResetToken(String token, User user, LocalDateTime creationDateTime, int expirationMinutes) {
        if((token == null) || (user == null) || (creationDateTime == null)) {
            throw new IllegalArgumentException("Null parameters");
        }
        this.token = token;
        this.user = user;
        this.expirationDate = expirationMinutes == 0?
                creationDateTime.plusMinutes(DEFAULT_TOKEN_LENGTH_IN_MINUTES) :
                creationDateTime.plusMinutes(expirationMinutes);
    }

    public String getToken() {
        return token;
    }

    public User getUser() {
        return user;
    }

    public LocalDateTime getExpirationDate() {
        return expirationDate;
    }
}
