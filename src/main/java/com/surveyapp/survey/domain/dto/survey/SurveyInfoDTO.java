package com.surveyapp.survey.domain.dto.survey;

import lombok.*;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class SurveyInfoDTO implements Serializable {

    @EqualsAndHashCode.Exclude
    private final long serialVersionUID = 1L;
    private Integer ID;
    @NotNull
    private LocalDateTime publishingDate;
    @EqualsAndHashCode.Exclude
    private boolean published;
}
