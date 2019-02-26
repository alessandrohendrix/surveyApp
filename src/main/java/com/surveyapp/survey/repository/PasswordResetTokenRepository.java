package com.surveyapp.survey.repository;

import com.surveyapp.survey.security.domain.PasswordResetToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface PasswordResetTokenRepository extends JpaRepository<PasswordResetToken, Integer> {

    PasswordResetToken findByToken(String token);

    @Query("SELECT ptr FROM PasswordResetToken ptr INNER JOIN ptr.user u WHERE ptr.user.ID = ?1")
    Set<PasswordResetToken> findAllByUserID(Integer userID);
}
