package com.surveyapp.survey.repository.security;

import com.surveyapp.survey.security.domain.entities.Role;
import com.surveyapp.survey.security.domain.enums.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role,Integer> {
    Role findByName(Roles role);
}
