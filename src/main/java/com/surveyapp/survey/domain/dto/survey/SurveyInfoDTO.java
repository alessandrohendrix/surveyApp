package com.surveyapp.survey.domain.dto.survey;

import com.surveyapp.survey.domain.dto.BaseEntityDTO;
import lombok.*;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class SurveyInfoDTO extends BaseEntityDTO {

    @NotNull
    private LocalDateTime publishingDate;
    @EqualsAndHashCode.Exclude
    private boolean published;
}
