package com.surveyapp.survey.domain.dto.survey;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SurveyInfoDTO implements Serializable {

    private final long serialVersionUID = 1L;
    private LocalDateTime publishingDate;
    private boolean published;
}
