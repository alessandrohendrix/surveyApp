package com.surveyapp.survey.repository;

import com.surveyapp.survey.security.domain.Role;
import com.surveyapp.survey.security.domain.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role,Integer> {
    Role findByName(Roles role);
}
