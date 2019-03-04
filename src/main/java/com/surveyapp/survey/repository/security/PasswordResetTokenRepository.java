package com.surveyapp.survey.repository.security;

import com.surveyapp.survey.security.domain.entities.PasswordResetToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public interface PasswordResetTokenRepository extends JpaRepository<PasswordResetToken, Integer> {

    Optional<PasswordResetToken> findByToken(String token);

    @Query("SELECT ptr FROM PasswordResetToken ptr INNER JOIN ptr.user u WHERE ptr.user.ID = ?1")
    Set<PasswordResetToken> findAllByUserID(Integer userID);
}
