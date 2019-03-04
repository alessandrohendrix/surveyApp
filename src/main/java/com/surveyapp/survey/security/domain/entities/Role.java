package com.surveyapp.survey.security.domain.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.surveyapp.survey.domain.entities.product.BaseEntity;
import com.surveyapp.survey.security.domain.enums.Roles;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="role")
@NoArgsConstructor
@Setter
@Getter
@EqualsAndHashCode
public class Role extends BaseEntity {

    @Enumerated(EnumType.STRING)
    private Roles name;
    @OneToMany(
            mappedBy = "role",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    @JsonIgnore
    @EqualsAndHashCode.Exclude
    private Set<User> users;
}
