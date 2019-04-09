package com.surveyapp.survey.domain.entities.survey.Enum;

import java.util.Arrays;
import java.util.List;

public enum SectionEnum {

    PRICE,
    TIME_TO_MARKET,
    MARKET_AVAILABILITY,
    PATIENT_SHARE;

    public static List<SectionEnum> getSections() {
        return Arrays.asList(SectionEnum.values());
    }
}
