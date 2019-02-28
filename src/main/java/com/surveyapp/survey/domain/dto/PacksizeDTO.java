package com.surveyapp.survey.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@EqualsAndHashCode
@Getter
@Setter
@NoArgsConstructor
public abstract class PacksizeDTO implements Serializable {

    @EqualsAndHashCode.Exclude
    @JsonIgnore
    private final long serialVersionUID = 1L;

    @EqualsAndHashCode.Exclude
    private int ID;

    @NotBlank
    @Min(value = 1)
    private int amount;

    @NotBlank
    private String type;

    @NotBlank
    @Min(value = 0l)
    private double weight;

    @NotBlank
    private String measure;

    @NotBlank
    @EqualsAndHashCode.Exclude
    private boolean volume;

    /** public PacksizeDTO() {
    }

    public long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getMeasure() {
        return measure;
    }

    public void setMeasure(String measure) {
        this.measure = measure;
    }

    public boolean isVolume() {
        return volume;
    }

    public void setVolume(boolean volume) {
        this.volume = volume;
    } **/
}
