package com.surveyapp.survey.domain.dto.survey;

import com.surveyapp.survey.domain.dto.product.CompetitorDTO;
import com.surveyapp.survey.domain.dto.product.ProductDTO;
import com.surveyapp.survey.domain.entities.survey.Enum.SectionEnum;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Map;
import java.util.Set;

@NoArgsConstructor
@Getter
@Setter
public class SurveyDTO extends SurveyCreationDTO{

    private ProductDTO product;
    private Set<CompetitorDTO> competitors;
    private Map<SectionEnum, List<KPIQuestionDTO>> kpiQuestionDTO;


    public SurveyDTO(Integer productID, SurveyInfoDTO surveyInfoDTO, SurveyQuestionDTO surveyQuestionDTO,
                     ProductDTO product, Set<CompetitorDTO> competitors,
                     Map<SectionEnum, List<KPIQuestionDTO>> kpiQuestionDTO) {

        super(productID, surveyInfoDTO, surveyQuestionDTO);
        this.product = product;
        this.competitors = competitors;
        this.kpiQuestionDTO = kpiQuestionDTO;
    }
}
