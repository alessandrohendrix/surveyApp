package com.surveyapp.survey.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@AllArgsConstructor
@EqualsAndHashCode
@Getter
@Setter
@NoArgsConstructor
public class DiseaseAreaDTO implements Serializable {

    @EqualsAndHashCode.Exclude
    @JsonIgnore
    private final long serialVersionUID = 1L;
    @NotBlank
    private String name;
    @EqualsAndHashCode.Exclude
    private int ID;

    /** public DiseaseAreaDTO() {
    }

    public long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    } **/
}
